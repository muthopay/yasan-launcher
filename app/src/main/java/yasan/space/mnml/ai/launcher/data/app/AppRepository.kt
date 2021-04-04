package yasan.space.mnml.ai.launcher.data.app

import android.content.Context
import androidx.lifecycle.LiveData

interface AppRepository {

    suspend fun getAppsFromRoomLive(): LiveData<List<App>>

    suspend fun getAppsFromRoom(): List<App>

    suspend fun getAppsFromPackageManager(context: Context): ArrayList<App>

    suspend fun updateRoomAppsUsingPackageManager(context: Context)

    suspend fun insertAppListIntoRoom(list: ArrayList<App>)

    suspend fun getFilteredApps(searched: String, apps: ArrayList<App>): ArrayList<App>

}
