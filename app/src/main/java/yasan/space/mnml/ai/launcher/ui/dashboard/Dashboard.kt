package yasan.space.mnml.ai.launcher.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Dashboard() {
    Box(modifier = Modifier.fillMaxSize().background(Color.Green)) {
        Text(text = "Dashboard")
    }
}