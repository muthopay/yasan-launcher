package yasan.space.mnml.ai.launcher.ui.home

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import yasan.space.mnml.ai.launcher.MainActivity
import yasan.space.mnml.ai.launcher.R
import yasan.space.mnml.ai.launcher.ui.theme.MyAppIcons
import yasan.space.mnml.ai.launcher.ui.theme.divider
import yasan.space.mnml.ai.launcher.ui.theme.grid

private const val TAG = "ButtonsBox"

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun ButtonsBox(activity: MainActivity?) {

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_foreground))
            .border(divider, colorResource(id = R.color.divider))
            .fillMaxWidth()
    ) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Icon(
                MyAppIcons.Dashboard,
                contentDescription = stringResource(R.string.home),
                tint = colorResource(id = R.color.text_desc),
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        Log.d(TAG, "ButtonsBox: Dashboard")
                    }
                    .padding(grid(1.5f))
            )
            Icon(
                MyAppIcons.Search,
                contentDescription = stringResource(R.string.home),
                tint = colorResource(id = R.color.text_desc),
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        Log.d(TAG, "ButtonsBox: Search")
                    }
                    .padding(grid(1.5f))
            )
            Icon(
                MyAppIcons.Apps,
                contentDescription = stringResource(R.string.home),
                tint = colorResource(id = R.color.text_desc),
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        Log.d(TAG, "ButtonsBox: Apps")
                    }
                    .padding(grid(1.5f))
            )
        }

    }

}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Preview
@Composable
fun ButtonsBoxPreview() {
    ButtonsBox(activity = null)
}
