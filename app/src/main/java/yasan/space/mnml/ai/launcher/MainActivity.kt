package yasan.space.mnml.ai.launcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import yasan.space.mnml.ai.launcher.ui.MainViewModel
import yasan.space.mnml.ai.launcher.ui.YasanLauncher

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            YasanLauncher(viewModel, this)
        }

    }

    override fun onResume() {
        super.onResume()

        viewModel.updateApps()
    }

}





