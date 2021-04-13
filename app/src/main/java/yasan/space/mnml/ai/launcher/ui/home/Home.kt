package yasan.space.mnml.ai.launcher.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import yasan.space.mnml.ai.launcher.MainActivity
import yasan.space.mnml.ai.launcher.data.app.App

@Composable
fun Home(apps: State<List<App>?>, activity: MainActivity) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        AppBox(apps, activity)
    }
}