package yasan.space.mnml.ai.launcher.ui.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import yasan.space.mnml.ai.launcher.data.app.App
import yasan.space.mnml.ai.launcher.data.app.AppRepository
import yasan.space.mnml.ai.launcher.util.DispatcherProvider
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application,
    private val appRepository: AppRepository,
    private val dispatchers: DispatcherProvider
) : AndroidViewModel(application) {

    companion object {
        private const val TAG = "HomeViewModel"
        private const val HOME_SIZE = 9
    }

    private var _homeApps = MutableLiveData<List<App>>()
    val homeApps: LiveData<List<App>> get() = _homeApps

    fun loadHomeApps(apps: List<App>?) = when {
        apps == null -> {
        }
        apps.isEmpty() -> {
            _homeApps.postValue(apps!!)
        }
        else -> {
            apps as ArrayList

            val newHomeApps = ArrayList<App>()
            var sortedApps = sortAppsByScore(apps)

            if (apps.size > HOME_SIZE) {
                sortedApps = sortedApps.slice(0 until HOME_SIZE) as ArrayList
            }
            newHomeApps.addAll(sortedApps)

            Log.d(TAG, "loadHomeApps: (${newHomeApps.size}) $newHomeApps")

            _homeApps.postValue(newHomeApps)
        }
    }

    private fun sortAppsByScore(apps: ArrayList<App>): ArrayList<App> {
        for (app in apps) app.loadScore(getApplication())
        apps.sortByDescending { it.score }
        return apps
    }

}