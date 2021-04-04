package yasan.space.mnml.ai.launcher.data.settings

interface SettingsRepository {

    fun setSearchFixTypos(enabled: Boolean)
    fun getSearchFixTypos(): Boolean
    val settingSearchFixTypos get() = getSearchFixTypos()

    fun setSearchPackageNames(enabled: Boolean)
    fun getSearchPackageNames(): Boolean
    val settingSearchPackageNames get() = getSearchPackageNames()

    fun setHomeSize(size: Int)
    fun getHomeSize(): Int
    val settingHomeSize get() = getHomeSize()

}
