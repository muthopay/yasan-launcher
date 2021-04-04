package yasan.space.mnml.ai.launcher.data.app

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import yasan.space.mnml.ai.launcher.data.settings.SettingsRepository
import yasan.space.mnml.ai.launcher.util.makeSearchReady
import javax.inject.Inject

class DefaultAppRepository @Inject constructor(
    private val db: AppDatabase,
    private val settingsRepo: SettingsRepository
) : AppRepository {

    override suspend fun getAppsFromRoomLive(): LiveData<List<App>> = db.appDao().getAppsLive()

    override suspend fun getAppsFromRoom(): List<App> = db.appDao().getApps()

    override suspend fun getAppsFromPackageManager(context: Context): ArrayList<App> {

        val apps = ArrayList<App>()
        val pm: PackageManager = context.packageManager
        val intent = Intent(Intent.ACTION_MAIN, null)
        intent.addCategory(Intent.CATEGORY_LAUNCHER)
        val allApps: MutableList<ResolveInfo> = pm.queryIntentActivities(intent, 0)

        for (resolveInfo in allApps) {
            val activityInfo: ActivityInfo = resolveInfo.activityInfo
            val app = App(
                resolveInfo.loadLabel(pm).toString(),
                activityInfo.packageName,
                activityInfo.name
            )
            apps.add(app)
        }

        return apps
    }

    override suspend fun updateRoomAppsUsingPackageManager(context: Context) {
        GlobalScope.launch(Dispatchers.IO) {
            val dao = db.appDao()
            val packageManagerApps = getAppsFromPackageManager(context)
            val roomApps = getAppsFromRoom()

            if (roomApps.isEmpty()) insertAppListIntoRoom(packageManagerApps)
            else {
                for (ra in roomApps) if (!packageManagerApps.contains(ra)) dao.delete(ra) // Delete app from Room if its not in package manager apps
                insertAppListIntoRoom(packageManagerApps)
            }
        }
    }

    override suspend fun insertAppListIntoRoom(list: ArrayList<App>) {
        val dao = db.appDao()
        for (app in list) dao.insert(app)
    }

    override suspend fun getFilteredApps(searched: String, apps: ArrayList<App>): ArrayList<App> {
        if (searched.isBlank()) return apps

        val filteredApps = ArrayList<App>()

        val search = searched.makeSearchReady()

        for (app in apps) {
            val label = app.label.makeSearchReady()

            if (settingsRepo.settingSearchPackageNames) {
                if (label.contains(search) || app.appPackageName.contains(search)) filteredApps.add(
                    app
                )
            } else {
                if (label.contains(search)) filteredApps.add(app)
            }

        }

        if (filteredApps.isNotEmpty() || !settingsRepo.settingSearchFixTypos) return filteredApps

        for (app in apps) {
            val label = app.label.makeSearchReady()
            val length = label.length
            if (length > 3 && search.length < 5) {
                val needed = length / 2
                var has = 0
                for (letter in search) if (label.contains(letter)) has++
                if (has >= needed) filteredApps.add(app)
            }
        }

        return filteredApps
    }

}
