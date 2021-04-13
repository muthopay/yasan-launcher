package yasan.space.mnml.ai.launcher

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import yasan.space.mnml.ai.launcher.data.app.App
import yasan.space.mnml.ai.launcher.ui.MainViewModel
import yasan.space.mnml.ai.launcher.ui.theme.YASANLauncherTheme

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            YasanLauncher(viewModel)
        }

        viewModel.loadApps()

    }

}


@Composable
fun YasanLauncher(viewModel: MainViewModel) {

    val apps = viewModel.apps.observeAsState()

    YASANLauncherTheme {
        Surface(color = Color.Blue, modifier = Modifier.fillMaxSize()) {
            Home(apps)
        }
    }
}

@Composable
fun Home(apps: State<List<App>?>) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        AppBox(apps)
    }
}

@Composable
fun AppBox(apps: State<List<App>?>) {
    Log.d(TAG, "AppBox: ")
    val list = apps.value

    when {
        list == null -> {
            Text(text = "Loading apps")
        }
        list.isEmpty() -> {
            Text(text = "No apps found")
        }
        else -> {
            Column(modifier = Modifier.border(2.dp, color = Color.Black)) {
                apps.value!!.forEach {
                    App(app = it)
                }
            }
        }
    }

}

@Composable
fun App(
    app: App
) {
    Text(
        text = app.label,
        modifier = Modifier
            .width(128.dp)
            .background(Color.White)
            .clickable {
                Log.d(TAG, "App: ${app.label} clicked ")
            }
            .padding(16.dp),
        textAlign = TextAlign.Center)
}