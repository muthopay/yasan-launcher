package yasan.space.mnml.ai.launcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import yasan.space.mnml.ai.launcher.ui.MainViewModel
import yasan.space.mnml.ai.launcher.ui.YasanLauncher
import yasan.space.mnml.ai.launcher.ui.drawer.Drawer
import yasan.space.mnml.ai.launcher.ui.home.Home
import yasan.space.mnml.ai.launcher.ui.home.HomeViewModel
import yasan.space.mnml.ai.launcher.ui.search.Search
import yasan.space.mnml.ai.launcher.ui.settings.SettingsScreen

private const val TAG = "MainActivity"

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            YasanLauncher(this)
        }

    }

    override fun onResume() {
        super.onResume()

        viewModel.updateApps()
    }

    @ExperimentalFoundationApi
    @ExperimentalAnimationApi
    @Composable
    fun NavGraph(startDestination: String = MainDestinations.HOME_ROUTE) {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = startDestination) {
            composable(MainDestinations.HOME_ROUTE) { backStackEntry ->
                val homeViewModel =
                    navController.hiltNavGraphViewModel<HomeViewModel>(MainDestinations.HOME_ROUTE)

                Home(
                    mainViewModel = viewModel,
                    viewModel = homeViewModel,
                    activity = this@MainActivity,
                    navController = navController
                )
            }
            composable(MainDestinations.DRAWER_ROUTE) {
                Drawer(
                    mainViewModel = viewModel,
                    activity = this@MainActivity,
                    navController = navController
                )
            }
            composable(MainDestinations.SEARCH_ROUTE) {
                Search()
            }
            composable(MainDestinations.SETTINGS_ROUTE) {
                SettingsScreen()
            }
        }

    }

}

object MainDestinations {
    const val HOME_ROUTE = "home"
    const val SEARCH_ROUTE = "search"
    const val DRAWER_ROUTE = "drawer"
    const val SETTINGS_ROUTE = "settings"
}



