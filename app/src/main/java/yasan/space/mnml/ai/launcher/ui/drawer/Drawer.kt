package yasan.space.mnml.ai.launcher.ui.drawer

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import yasan.space.mnml.ai.launcher.MainActivity
import yasan.space.mnml.ai.launcher.R
import yasan.space.mnml.ai.launcher.data.app.App
import yasan.space.mnml.ai.launcher.ui.MainViewModel
import yasan.space.mnml.ai.launcher.ui.common.YasanDivider
import yasan.space.mnml.ai.launcher.ui.common.YasanTitleBarHome
import yasan.space.mnml.ai.launcher.ui.theme.appHomeSize
import yasan.space.mnml.ai.launcher.ui.theme.grid
import yasan.space.mnml.ai.launcher.util.AndroidDrawablePainterAlt


@ExperimentalAnimationApi
@Composable
fun Drawer(
    mainViewModel: MainViewModel,
    activity: MainActivity,
    navController: NavHostController
) {

    val allApps = mainViewModel.apps.observeAsState()

    val listState = rememberLazyListState()

    val list = allApps.value ?: ArrayList()

    Column() {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .weight(1f)
        ) {
            itemsIndexed(list) { index, app ->
                AppDrawer(app = app, activity = activity)
            }
        }
        YasanTitleBarHome(title = stringResource(id = R.string.drawer), navController)
    }


}

@ExperimentalAnimationApi
@Composable
fun AppDrawer(
    app: App,
    activity: MainActivity
) {
    val paddingSize = grid(1.5f)
    val drawable = app.requireIcon(activity)!!
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable {
                app.launch(activity)
            }) {
            Image(
                painter = AndroidDrawablePainterAlt(drawable.mutate()),
                contentDescription = app.label,
                modifier = Modifier
                    .requiredSize(appHomeSize)
                    .padding(paddingSize),
                alignment = Alignment.Center,
                contentScale = ContentScale.Fit
            )
            Text(
                text = app.label,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(0.dp, paddingSize, paddingSize, paddingSize)
            )
        }
        YasanDivider()
    }
}
