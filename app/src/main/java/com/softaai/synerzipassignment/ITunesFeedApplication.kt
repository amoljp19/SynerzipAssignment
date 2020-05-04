package com.softaai.synerzipassignment
//
//import android.app.Application
//import android.content.Context
//import androidx.multidex.MultiDex
//import com.softaai.synerzipassignment.di.networkModule
//import com.softaai.synerzipassignment.di.persistenceModule
//import com.softaai.synerzipassignment.di.repositoryModule
//import com.softaai.synerzipassignment.di.viewModelModule
//import org.koin.android.ext.koin.androidContext
//import org.koin.core.context.startKoin
//import timber.log.Timber
//
//class ITunesFeedApplication : Application(){
//
//    override fun attachBaseContext(base: Context?) {
//        super.attachBaseContext(base)
//        MultiDex.install(this)
//    }
//
//    override fun onCreate() {
//        super.onCreate()
//        startKoin {
//            androidContext(this@ITunesFeedApplication)
//            modules(listOf(networkModule, persistenceModule,
//                repositoryModule, viewModelModule))
//        }
//
//        if (BuildConfig.DEBUG) {
//            Timber.plant(Timber.DebugTree())
//        }
//    }
//}