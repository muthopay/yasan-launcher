package yasan.space.mnml.ai.launcher.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import yasan.space.mnml.ai.launcher.MainActivity
import yasan.space.mnml.ai.launcher.R
import yasan.space.mnml.ai.launcher.ui.MainViewModel
import yasan.space.mnml.ai.launcher.ui.theme.grid

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun Home(
    mainViewModel: MainViewModel,
    activity: MainActivity,
    viewModel: HomeViewModel,
    navController: NavHostController
) {

    val allApps = mainViewModel.apps.observeAsState()
    val homeApps = viewModel.homeApps.observeAsState()
    val buttonsVisible = viewModel.buttons.observeAsState()

    viewModel.loadHomeApps(allApps.value)

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.default_home_background))
            .clickable {
                viewModel.toggleButtons()
            },
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.width(200.dp)) {
            AppBox(homeApps, activity)
            Spacer(modifier = Modifier.requiredHeight(grid))
            AnimatedVisibility(visible = buttonsVisible.value != false) {
                ButtonsBox(activity, navController)
            }
        }
    }
}