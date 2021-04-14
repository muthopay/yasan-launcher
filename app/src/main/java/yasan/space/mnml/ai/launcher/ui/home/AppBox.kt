package yasan.space.mnml.ai.launcher.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import yasan.space.mnml.ai.launcher.MainActivity
import yasan.space.mnml.ai.launcher.R
import yasan.space.mnml.ai.launcher.data.app.App
import yasan.space.mnml.ai.launcher.ui.app.AppHome

@ExperimentalFoundationApi
@Composable
fun AppBox(apps: State<List<App>?>, activity: MainActivity) {
    val list = apps.value

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_foreground))
            .border(2.dp, colorResource(id = R.color.divider))
    ) {
        when {
            list == null -> {
                Text(text = stringResource(R.string.apps_loading))
            }
            list.isEmpty() -> {
                Text(text = stringResource(R.string.apps_none_found))
            }
            else -> {
                LazyVerticalGrid(
                    cells = GridCells.Fixed(3),
                    modifier = Modifier
                        .padding(8.dp)
                        .width(192.dp)
                        .height(192.dp)
                ) {
                    items(count = list.size) {
                        AppHome(app = list[it], activity = activity)
                    }
                }
            }
        }
    }


}