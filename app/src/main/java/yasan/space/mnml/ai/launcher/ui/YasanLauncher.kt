package yasan.space.mnml.ai.launcher.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import yasan.space.mnml.ai.launcher.MainActivity
import yasan.space.mnml.ai.launcher.ui.home.Home
import yasan.space.mnml.ai.launcher.ui.theme.YASANLauncherTheme

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun YasanLauncher(viewModel: MainViewModel, activity: MainActivity) {

    val apps = viewModel.apps.observeAsState()

    YASANLauncherTheme {
        Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
            Home(apps, activity)
        }
    }

}