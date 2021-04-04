package yasan.space.mnml.ai.launcher.data.settings

import android.content.SharedPreferences
import javax.inject.Inject


class DefaultSettingsRepository @Inject constructor(
    private val sp: SharedPreferences
) : SettingsRepository {

    override fun setSearchFixTypos(enabled: Boolean) {
        sp.edit().putBoolean(SETTING_SEARCH_FIX_TYPOS, enabled).apply()
    }

    override fun getSearchFixTypos() =
        sp.getBoolean(SETTING_SEARCH_FIX_TYPOS, SETTING_SEARCH_FIX_TYPOS_DEFAULT)

    override fun setSearchPackageNames(enabled: Boolean) =
        sp.edit().putBoolean(SETTING_SEARCH_PACKAGE_NAMES, enabled).apply()

    override fun getSearchPackageNames() =
        sp.getBoolean(SETTING_SEARCH_PACKAGE_NAMES, SETTING_SEARCH_PACKAGE_NAMES_DEFAULT)

    override fun setHomeSize(size: Int) =
        sp.edit().putInt(SETTING_HOME_SIZE, size).apply()

    override fun getHomeSize() = sp.getInt(SETTING_HOME_SIZE, SETTING_HOME_SIZE_DEFAULT)

}
