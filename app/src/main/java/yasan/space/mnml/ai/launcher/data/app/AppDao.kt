package yasan.space.mnml.ai.launcher.data.app

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * [App] data access object (DAO). Used to read & write [App]s.
 */
@Dao
interface AppDao {

    @Query("SELECT * FROM apps WHERE NOT (id = 'yasan.space.mnml.ai.launcher.yasan.space.mnml.ai.launcher.ui.MainActivity') ORDER BY label ASC")
    fun getAppsLive(): LiveData<List<App>>

    @Query("SELECT * FROM apps WHERE NOT (id = 'yasan.space.mnml.ai.launcher.yasan.space.mnml.ai.launcher.ui.MainActivity') ORDER BY label ASC")
    fun getApps(): List<App>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(app: App)

    @Update
    suspend fun update(app: App)

    @Delete
    suspend fun delete(app: App)
}
