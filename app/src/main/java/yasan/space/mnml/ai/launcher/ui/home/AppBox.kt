package yasan.space.mnml.ai.launcher.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import yasan.space.mnml.ai.launcher.MainActivity
import yasan.space.mnml.ai.launcher.data.app.App
import yasan.space.mnml.ai.launcher.ui.app.AppHome

@ExperimentalFoundationApi
@Composable
fun AppBox(apps: State<List<App>?>, activity: MainActivity) {
    val list = apps.value

    when {
        list == null -> {
            Text(text = "Loading apps")
        }
        list.isEmpty() -> {
            Text(text = "No apps found")
        }
        else -> {
            LazyVerticalGrid(
                cells = GridCells.Fixed(3),
                modifier = Modifier
                    .background(Color.Red)
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