package yasan.space.mnml.ai.launcher.ui

import android.app.Application
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

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val dispatchers: DispatcherProvider,
    private val appRepository: AppRepository
) : AndroidViewModel(application) {

    private var _apps = MutableLiveData<ArrayList<App>>()
    val apps: LiveData<ArrayList<App>> get() = _apps

    fun updateApps() {
        viewModelScope.launch(dispatchers.io) {
            val a: ArrayList<App> =
                appRepository.updateRoomAppsUsingPackageManager(getApplication())
            _apps.postValue(a)
        }
    }

}