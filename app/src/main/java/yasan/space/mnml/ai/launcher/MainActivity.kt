package yasan.space.mnml.ai.launcher

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import yasan.space.mnml.ai.launcher.ui.theme.YASANLauncherTheme

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YasanLauncher()
        }
    }
}

@Composable
fun YasanLauncher() {
    YASANLauncherTheme {
        val apps = ArrayList<App>().apply { repeat(9) { add(App("App $it")) } }

        Surface(color = Color.Blue, modifier = Modifier.fillMaxSize()) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                AppBox(apps = apps)
            }
        }

    }
}


@Composable
fun AppBox(apps: List<App>) {
    Column(modifier = Modifier.border(2.dp, color = Color.Black)) {
        apps.forEach {
            App(app = it)
        }
    }
}

data class App(val label: String)

@Composable
fun App(
    app: App
) {
    Text(
        text = app.label,
        modifier = Modifier
            .background(Color.White)
            .clickable {
                Log.d(TAG, "App: ${app.label} clicked ")
            }
            .padding(16.dp),
        textAlign = TextAlign.Center)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    YasanLauncher()
}