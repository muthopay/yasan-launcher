package yasan.space.mnml.ai.launcher.data.app

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import dev.yasan.helper.library.closeKeyboard
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import yasan.space.mnml.ai.launcher.shared.AI

@Entity(tableName = "apps")
@Parcelize
data class App(val label: String, val appPackageName: String, val appClassName: String) :
    Parcelable {

    companion object {
        private const val TAG = "App"
    }

    /**
     * Returns app's AI score. The higher the better.
     */
    fun loadScore(context: Context): Int {
        score = AI.getAppScore(this, context)
        return score
    }

    @IgnoredOnParcel
    var score: Int = 0

    @IgnoredOnParcel
    @PrimaryKey(autoGenerate = false)
    var id: String = "$appPackageName.$appClassName"

    /**
     * Launches the app.
     *
     * @return If launch was successful or not.
     */
    fun launch(activity: Activity): Boolean {
        return try {
            activity.closeKeyboard()
            val intent = Intent(Intent.ACTION_MAIN)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.setClassName(appPackageName, appClassName)
            activity.startActivity(intent)
            AI.recordAppLaunch(this, activity)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    fun uninstall(context: Context) {
        val intent = Intent(
            Intent.ACTION_DELETE,
            Uri.fromParts("package", appPackageName, null)
        )
        context.startActivity(intent)
    }

    @IgnoredOnParcel
    @Ignore
    var icon: Drawable? = null

    fun requireIcon(context: Context): Drawable? = icon ?: getIconFromPackageManager(context)

    private fun getIconFromPackageManager(context: Context): Drawable? {
        var drawable: Drawable? = null
        try {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.setClassName(appPackageName, appClassName)
            drawable = context.packageManager.getActivityIcon(intent)
        } catch (e: Exception) {
            try {
                drawable = context.packageManager.getApplicationIcon(appPackageName)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return drawable
    }

    override fun toString() = "label (s:$score)"

    override fun equals(other: Any?): Boolean {

        if (javaClass != other?.javaClass) return false

        other as App

        if (appPackageName != other.appPackageName) return false
        if (appClassName != other.appClassName) return false
        if (label != other.label) return false

        return true
    }

    /**
     * Checks if the [App] object is the same as the [otherApp] by comparing their [id]s.
     */
    fun isTheSameAs(otherApp: App) = id == otherApp.id

    override fun hashCode(): Int {
        var result = label.hashCode()
        result = 31 * result + appPackageName.hashCode()
        result = 31 * result + appClassName.hashCode()
        result = 31 * result + id.hashCode()
        return result
    }
}
