package com.matheusbrandao.rickandmorty

import androidx.multidex.MultiDexApplication
import com.matheusbrandao.rickandmorty.di.*
import org.koin.android.ext.android.startKoin

class AndroidApplication: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this,
            listOf(
                androidModule,
                componentsModule,
                dataSourceModule,
                domainModule,
                presentationModule,
                repositoryModule,
                serviceModule
            ))
    }
}