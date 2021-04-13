package yasan.space.mnml.ai.launcher.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import yasan.space.mnml.ai.launcher.data.app.App
import yasan.space.mnml.ai.launcher.data.app.AppRepository
import yasan.space.mnml.ai.launcher.util.DispatcherProvider
import javax.inject.Inject

private const val TAG = "MainViewModel"

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val dispatchers: DispatcherProvider,
    private val appRepository: AppRepository
) : AndroidViewModel(application) {

    private var _apps = MutableLiveData<List<App>>()
    val apps: LiveData<List<App>> get() = _apps

    fun loadApps() {
        Log.d(TAG, "loadApps: start")
        viewModelScope.launch(dispatchers.io) {
            val a: List<App> = appRepository.getAppsFromPackageManager(getApplication())
            _apps.postValue(a)
        }
        Log.d(TAG, "loadApps: finish")
    }

}