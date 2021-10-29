package br.com.liebersonsantos.animemangalist

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Created by lieberson on 10/15/21.
 * @author lieberson.xsantos@gmail.com
 */
@HiltAndroidApp
class CustomApp: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}