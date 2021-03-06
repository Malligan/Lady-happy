package com.egoriku.core.di

import com.egoriku.core.IApplication
import com.egoriku.core.actions.ILandingFragmentAction
import com.egoriku.core.actions.IMainActivityAction
import com.egoriku.core.actions.IPhotoReportFragmentAction
import com.egoriku.core.actions.ISettingsFragmentAction
import com.egoriku.core.di.utils.IAnalytics
import com.egoriku.core.di.utils.IFirebaseFirestore
import com.egoriku.core.di.utils.INavigationHolder
import com.egoriku.core.di.utils.IRouter
import com.egoriku.core.repository.ILandingRepository
import com.egoriku.core.repository.IPhotoReportRepository

interface ApplicationProvider :
        DependenciesProvider,
        MainActivityFeatureProvider,
        LandingFeatureProvider,
        PhotoReportFeatureProvider,
        RepositoryProvider,
        SettingsFeatureProvider

interface DependenciesProvider {
    fun provideContext(): IApplication

    fun provideFirebaseFirestore(): IFirebaseFirestore

    fun provideAnalyticsHelper(): IAnalytics

    fun provideRouter(): IRouter

    fun provideNavigationHolder(): INavigationHolder
}

interface MainActivityFeatureProvider {
    fun provideMainActivityAction(): IMainActivityAction
}

interface LandingFeatureProvider {
    fun provideLandingFragmentAction(): ILandingFragmentAction
}

interface PhotoReportFeatureProvider {
    fun providePhotoReportFragmentAction(): IPhotoReportFragmentAction
}

interface SettingsFeatureProvider {
    fun provideSettingsFragment(): ISettingsFragmentAction
}

interface RepositoryProvider {
    fun provideLandingRepository(): ILandingRepository

    fun providePhotoReportRepository(): IPhotoReportRepository
}