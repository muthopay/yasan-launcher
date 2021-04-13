package yasan.space.mnml.ai.launcher.ui.app

import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import yasan.space.mnml.ai.launcher.MainActivity
import yasan.space.mnml.ai.launcher.data.app.App
import kotlin.math.roundToInt

@Composable
fun AppHome(
    app: App,
    activity: MainActivity
) {
    val drawable = app.requireIcon(activity)!!
    Image(
        painter = MyAndroidDrawablePainter(drawable.mutate()),
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

// Clean this

private val MAIN_HANDLER by lazy(LazyThreadSafetyMode.NONE) {
    Handler(Looper.getMainLooper())
}

class MyAndroidDrawablePainter(
    private val drawable: Drawable
) : Painter() {
    private var invalidateTick by mutableStateOf(0)
    private var startedAnimatable = drawable is Animatable && drawable.isRunning

    init {
        drawable.callback = object : Drawable.Callback {
            override fun invalidateDrawable(d: Drawable) {
                // Update the tick so that we get re-drawn
                invalidateTick++
            }

            override fun scheduleDrawable(d: Drawable, what: Runnable, time: Long) {
                MAIN_HANDLER.postAtTime(what, time)
            }

            override fun unscheduleDrawable(d: Drawable, what: Runnable) {
                MAIN_HANDLER.removeCallbacks(what)
            }
        }
    }

    override fun applyAlpha(alpha: Float): Boolean {
        drawable.alpha = (alpha * 255).roundToInt().coerceIn(0, 255)
        return true
    }

    override fun applyColorFilter(colorFilter: ColorFilter?): Boolean {
        drawable.colorFilter = colorFilter?.asAndroidColorFilter()
        return true
    }

    override fun applyLayoutDirection(layoutDirection: LayoutDirection): Boolean {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable.setLayoutDirection(
                when (layoutDirection) {
                    LayoutDirection.Ltr -> View.LAYOUT_DIRECTION_LTR
                    LayoutDirection.Rtl -> View.LAYOUT_DIRECTION_RTL
                }
            )
        }
        return false
    }

    override val intrinsicSize: Size
        get() = Size(
            width = drawable.intrinsicWidth.toFloat(),
            height = drawable.intrinsicHeight.toFloat()
        )

    override fun DrawScope.onDraw() {
        if (!startedAnimatable && drawable is Animatable && !drawable.isRunning) {
            // If the drawable is Animatable, start it on the first draw
            drawable.start()
            startedAnimatable = true
        }

        drawIntoCanvas { canvas ->
            // Reading this ensures that we invalidate when invalidateDrawable() is called
            invalidateTick

            drawable.setBounds(0, 0, size.width.toInt(), size.height.toInt())

            canvas.withSave {
                // Painters are responsible for scaling content to meet the canvas size
/*                if (drawable.intrinsicWidth > 0 && drawable.intrinsicHeight > 0) {
                    canvas.scale(
                        sx = size.width / drawable.intrinsicWidth,
                        sy = size.height / drawable.intrinsicHeight
                    )
                }*/
                drawable.draw(canvas.nativeCanvas)
            }
        }
    }
}