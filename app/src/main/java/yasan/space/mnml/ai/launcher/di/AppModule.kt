package yasan.space.mnml.ai.launcher.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.yasan.helper.library.getMySharedPreferences
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import yasan.space.mnml.ai.launcher.data.app.AppDatabase
import yasan.space.mnml.ai.launcher.data.app.AppRepository
import yasan.space.mnml.ai.launcher.data.app.DefaultAppRepository
import yasan.space.mnml.ai.launcher.data.settings.DefaultSettingsRepository
import yasan.space.mnml.ai.launcher.data.settings.SettingsRepository
import yasan.space.mnml.ai.launcher.util.ApplicationScope
import yasan.space.mnml.ai.launcher.util.DispatcherProvider
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideCalendar(): Calendar = Calendar.getInstance()

    @Singleton
    @Provides
    fun provideAppDatabase(
        app: Application,
        callback: AppDatabase.CallBack
    ) = Room.databaseBuilder(app, AppDatabase::class.java, "app_database")
        .fallbackToDestructiveMigration()
        .addCallback(callback)
        .build()

    @Provides
    fun provideAppDao(db: AppDatabase) = db.appDao()

    @Singleton
    @Provides
    fun provideAppRepository(
        appDatabase: AppDatabase,
        settingsRepo: SettingsRepository
    ): AppRepository =
        DefaultAppRepository(appDatabase, settingsRepo)

    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())

    @Singleton
    @Provides
    fun provideSettingsRepository(sp: SharedPreferences): SettingsRepository =
        DefaultSettingsRepository(sp)

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getMySharedPreferences()

    @Singleton
    @Provides
    fun provideDispatchers(): DispatcherProvider = object : DispatcherProvider {
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined
    }

}

