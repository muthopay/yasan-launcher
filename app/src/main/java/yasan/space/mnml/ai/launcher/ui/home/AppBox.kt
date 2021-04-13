package yasan.space.mnml.ai.launcher.ui.home

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import yasan.space.mnml.ai.launcher.MainActivity
import yasan.space.mnml.ai.launcher.data.app.App
import yasan.space.mnml.ai.launcher.ui.app.AppHome

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
            Column(modifier = Modifier.border(2.dp, color = Color.Black)) {
                apps.value!!.forEach {
                    AppHome(app = it, activity = activity)
                }
            }
        }
    }

}