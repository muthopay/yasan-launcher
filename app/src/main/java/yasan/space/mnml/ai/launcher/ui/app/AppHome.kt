package yasan.space.mnml.ai.launcher.ui.app

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import yasan.space.mnml.ai.launcher.MainActivity
import yasan.space.mnml.ai.launcher.data.app.App

@Composable
fun AppHome(
    app: App,
    activity: MainActivity
) {
    Column() {
        Text(
            text = app.label,
            modifier = Modifier
                .width(128.dp)
                .background(Color.White)
                .clickable {
                    app.launch(activity)
                }
                .padding(16.dp),
            textAlign = TextAlign.Center)
    }

}