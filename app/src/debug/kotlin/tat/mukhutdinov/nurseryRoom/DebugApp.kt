package tat.mukhutdinov.nurseryRoom

import android.app.Application
import android.os.StrictMode
import com.facebook.stetho.Stetho
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import tat.mukhutdinov.nurseryRoom.infrastructure.di.InjectionModules
import timber.log.Timber

class DebugApp : Application() {

    override fun onCreate() {
        super.onCreate()

        setupKoin()

        setupTimber()

        setupStetho()

        setupUncaughtExceptions()

        setupStrictMode()
    }

    private fun setupUncaughtExceptions() {
        Thread.setDefaultUncaughtExceptionHandler { _, throwable ->
            Timber.e(throwable)
        }
    }

    private fun setupStrictMode() {
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .penaltyFlashScreen()
                .build()
        )

        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build()
        )
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun setupStetho() {
        Stetho.initializeWithDefaults(this)
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@DebugApp)

            modules(InjectionModules.modules)
        }
    }
}