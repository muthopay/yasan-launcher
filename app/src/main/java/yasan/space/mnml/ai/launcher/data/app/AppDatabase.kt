package yasan.space.mnml.ai.launcher.data.app

import androidx.room.Database
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import yasan.space.mnml.ai.launcher.data.app.App
import yasan.space.mnml.ai.launcher.util.ApplicationScope
import javax.inject.Inject
import javax.inject.Provider

/**
 * Room database abstract class for apps database.
 *
 * @see App
 * @see RoomDatabase
 */
@Database(entities = [App::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appDao(): AppDao

    class CallBack @Inject constructor(
        private val database: Provider<AppDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback()
}
