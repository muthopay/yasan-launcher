package yasan.space.mnml.ai.launcher.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import yasan.space.mnml.ai.launcher.MainActivity
import yasan.space.mnml.ai.launcher.R
import yasan.space.mnml.ai.launcher.data.app.App
import yasan.space.mnml.ai.launcher.ui.theme.grid

@ExperimentalFoundationApi
@Composable
fun Home(apps: State<List<App>?>, activity: MainActivity) {

    val viewModel: HomeViewModel = viewModel()

    viewModel.loadHomeApps(apps.value)

    val homeApps = viewModel.homeApps.observeAsState()

    Box(
        modifier = Modifier.background(colorResource(id = R.color.default_home_background)),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.width(200.dp)) {
            AppBox(homeApps, activity)
            Spacer(modifier = Modifier.height(grid))
            ButtonsBox(activity)
        }
    }
}