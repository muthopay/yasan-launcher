package yasan.space.mnml.ai.launcher.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import yasan.space.mnml.ai.launcher.MainActivity
import yasan.space.mnml.ai.launcher.R
import yasan.space.mnml.ai.launcher.ui.theme.divider

@ExperimentalFoundationApi
@Composable
fun ButtonsBox(activity: MainActivity) {

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_foreground))
            .border(divider, colorResource(id = R.color.divider))
            .fillMaxWidth()
    ) {

        Row() {
            Button(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f)) {

            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f)) {

            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f)) {

            }
        }

    }

}