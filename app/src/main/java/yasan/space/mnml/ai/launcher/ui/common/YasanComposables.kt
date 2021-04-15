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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import yasan.space.mnml.ai.launcher.R
import yasan.space.mnml.ai.launcher.ui.theme.MyAppIcons
import yasan.space.mnml.ai.launcher.ui.theme.grid

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
                text = title.capitalize(),
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
fun YasanDivider() {
    Divider(color = colorResource(id = R.color.divider))
}

val rubikFamily = FontFamily(

    Font(R.font.black, FontWeight.Black, FontStyle.Normal),
    Font(R.font.blackitalic, FontWeight.Black, FontStyle.Italic),

    Font(R.font.bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.bolditalic, FontWeight.Bold, FontStyle.Italic),

    Font(R.font.light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.lightitalic, FontWeight.Light, FontStyle.Italic),

    Font(R.font.medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.mediumitalic, FontWeight.Medium, FontStyle.Italic),

    Font(R.font.regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.italic, FontWeight.Normal, FontStyle.Italic),

    )

val rubikMonoFamily = FontFamily(
    Font(R.font.mono)
)