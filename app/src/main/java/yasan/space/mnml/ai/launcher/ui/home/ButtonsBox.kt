package yasan.space.mnml.ai.launcher.ui.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import yasan.space.mnml.ai.launcher.MainActivity
import yasan.space.mnml.ai.launcher.MainDestinations
import yasan.space.mnml.ai.launcher.R
import yasan.space.mnml.ai.launcher.ui.theme.MyAppIcons
import yasan.space.mnml.ai.launcher.ui.theme.divider
import yasan.space.mnml.ai.launcher.ui.theme.grid

private const val TAG = "ButtonsBox"

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun ButtonsBox(activity: MainActivity?, navController: NavHostController) {

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_foreground))
            .border(divider, colorResource(id = R.color.divider))
            .fillMaxWidth()
    ) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Icon(
                MyAppIcons.Search,
                contentDescription = stringResource(R.string.home),
                tint = colorResource(id = R.color.text_desc),
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        navController.navigate(MainDestinations.SEARCH_ROUTE)
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
                        navController.navigate(MainDestinations.DRAWER_ROUTE)
                    }
                    .padding(grid(1.5f))
            )
        }

    }

}