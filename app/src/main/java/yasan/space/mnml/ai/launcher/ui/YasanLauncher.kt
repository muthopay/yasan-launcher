package yasan.space.mnml.ai.launcher.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.rememberNavController
import yasan.space.mnml.ai.launcher.MainActivity
import yasan.space.mnml.ai.launcher.R
import yasan.space.mnml.ai.launcher.ui.theme.YASANLauncherTheme

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun YasanLauncher(activity: MainActivity) {

    YASANLauncherTheme {
        Surface(
            color = colorResource(id = R.color.layer_midground),
            modifier = Modifier.fillMaxSize()
        ) {
            activity.NavGraph()
        }

    }

}