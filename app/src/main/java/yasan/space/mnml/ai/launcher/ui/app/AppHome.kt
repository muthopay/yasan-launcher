package yasan.space.mnml.ai.launcher.ui.app

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import yasan.space.mnml.ai.launcher.MainActivity
import yasan.space.mnml.ai.launcher.data.app.App
import yasan.space.mnml.ai.launcher.ui.theme.appHomeSize
import yasan.space.mnml.ai.launcher.ui.theme.grid
import yasan.space.mnml.ai.launcher.util.AndroidDrawablePainterAlt

@ExperimentalAnimationApi
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
            .requiredWidth(appHomeSize)
            .requiredHeight(appHomeSize)
            .clickable {
                app.launch(activity)
            }
            .padding(grid(1.5f)),
        alignment = Alignment.Center,
        contentScale = ContentScale.Fit
    )

}
