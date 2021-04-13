package yasan.space.mnml.ai.launcher.ui.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.imageloading.toPainter
import yasan.space.mnml.ai.launcher.MainActivity
import yasan.space.mnml.ai.launcher.data.app.App

@Composable
fun AppHome(
    app: App,
    activity: MainActivity
) {
    val drawable = app.requireIcon(activity)!!
    Image(
        painter = drawable.toPainter(),
        contentDescription = app.label,
        modifier = Modifier
            .width(64.dp)
            .height(64.dp)
            .padding(12.dp)
            .clickable {
                app.launch(activity)
            },
        alignment = Alignment.Center
    )


}