package yasan.space.mnml.ai.launcher.ui.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import yasan.space.mnml.ai.launcher.MainActivity
import yasan.space.mnml.ai.launcher.data.app.App
import yasan.space.mnml.ai.launcher.util.AndroidDrawablePainterAlt

@Composable
fun AppHome(
    app: App,
    activity: MainActivity
) {
    val drawable = app.requireIcon(activity)!!
    Image(
        painter = AndroidDrawablePainterAlt(drawable.mutate()),
        contentDescription = app.label,
        modifier = Modifier
            .width(64.dp)
            .height(64.dp)
            .background(Color.Green)
            .clickable {
                app.launch(activity)
            }
            .padding(12.dp),
        alignment = Alignment.Center,
        contentScale = ContentScale.Fit
    )

}
