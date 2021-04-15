package yasan.space.mnml.ai.launcher.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import yasan.space.mnml.ai.launcher.MainDestinations
import yasan.space.mnml.ai.launcher.R
import yasan.space.mnml.ai.launcher.ui.theme.MyAppIcons
import yasan.space.mnml.ai.launcher.ui.theme.grid
import java.util.*

@Composable
fun YasanTitleBar(
    title: String = stringResource(id = R.string.placeholder),
    navController: NavHostController
) {
    Column() {
        YasanDivider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.layer_foreground))
                .clickable {
                    navController.navigateUp()
                }
        ) {
            Icon(
                MyAppIcons.ArrowBack,
                contentDescription = stringResource(R.string.go_back),
                tint = colorResource(id = R.color.text_title),
                modifier = Modifier
                    .padding(grid(2))
            )
            Text(
                text = title.capitalize(Locale.getDefault()),
                color = colorResource(id = R.color.text_title),
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = grid(2)),
                fontFamily = rubikFamily,
                fontWeight = FontWeight.Bold,
            )
        }

    }
}

@Composable
fun YasanTitleBarHome(
    title: String = stringResource(id = R.string.placeholder),
    navController: NavHostController
) {
    Column() {
        YasanDivider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.layer_foreground))
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        navController.navigateUp()
                    }
            ) {
                Icon(
                    MyAppIcons.ArrowBack,
                    contentDescription = stringResource(R.string.go_back),
                    tint = colorResource(id = R.color.text_title),
                    modifier = Modifier
                        .padding(grid(2))
                )
                Text(
                    text = title.capitalize(Locale.getDefault()),
                    color = colorResource(id = R.color.text_title),
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = grid(2)),
                    fontFamily = rubikFamily,
                    fontWeight = FontWeight.Bold,
                )
            }
            Icon(
                MyAppIcons.Settings,
                contentDescription = stringResource(R.string.go_back),
                tint = colorResource(id = R.color.text_title),
                modifier = Modifier
                    .clickable {
                        navController.navigate(MainDestinations.SETTINGS_ROUTE)
                    }
                    .padding(grid(2))
            )
        }
    }
}

@Composable
fun YasanDivider() {
    Divider(color = colorResource(id = R.color.divider))
}