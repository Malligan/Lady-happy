package com.egoriku.core.di

import com.egoriku.core.IApplication
import com.egoriku.core.actions.MainActivityAction
import com.egoriku.core.actions.MainFragmentAction
import com.egoriku.core.di.utils.IAnalyticsHelper
import com.egoriku.core.di.utils.IFirebaseFirestore
import com.egoriku.core.di.utils.INavigationHolder
import com.egoriku.core.di.utils.IRouter
import com.egoriku.core.repository.ILandingRepository
import com.egoriku.core.repository.IPhotoReportRepository

interface ApplicationProvider :
        MainToolsProvider,
        MainActivityProvider,
        MainFragmentProvider,
        RepositoryProvider

interface MainToolsProvider {
    fun provideContext(): IApplication

    fun provideFirebaseFirestore(): IFirebaseFirestore

    fun provideAnalyticsHelper(): IAnalyticsHelper

    fun provideRouter(): IRouter

    fun provideNavigationHolder(): INavigationHolder
}

interface MainActivityProvider {
    fun provideMainActivityAction(): MainActivityAction
}

interface MainFragmentProvider {
    fun provideMainFragmentAction(): MainFragmentAction
}

interface RepositoryProvider {
    fun provideLandingRepository(): ILandingRepository

    fun providePhotoReportRepository(): IPhotoReportRepository
}