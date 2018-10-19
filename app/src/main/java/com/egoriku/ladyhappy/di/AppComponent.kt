package com.egoriku.ladyhappy.di

import com.egoriku.core.di.*
import com.egoriku.featureactivitymain.di.MainActivityExportComponent
import com.egoriku.ladyhappy.Application
import com.egoriku.landingfragment.di.LandingFragmentExportComponent
import com.egoriku.photoreportfragment.di.PhotoReportFragmentExportComponent
import com.egoriku.storage.di.StorageComponent
import dagger.Component

@Component(
        dependencies = [
            DependenciesProvider::class,
            MainActivityProvider::class,
            LandingFragmentProvider::class,
            PhotoReportFragmentProvider::class,
            RepositoryProvider::class
        ])
@ApplicationScope
interface AppComponent : ApplicationProvider {

    fun inject(app: Application)

    class Initializer private constructor() {
        companion object {
            fun init(app: Application): AppComponent {
                val dependenciesProvider = DependenciesComponent.Initializer.init(app)
                val mainActivityProvider = MainActivityExportComponent.Initializer.init()

                val landingFragmentProvider = LandingFragmentExportComponent.Initializer.init()
                val photoReportFragmentProvider = PhotoReportFragmentExportComponent.Initializer.init()

                val repositoryProvider = StorageComponent.Initializer.init(dependenciesProvider)

                return DaggerAppComponent.builder()
                        .dependenciesProvider(dependenciesProvider)
                        .mainActivityProvider(mainActivityProvider)
                        .landingFragmentProvider(landingFragmentProvider)
                        .photoReportFragmentProvider(photoReportFragmentProvider)
                        .repositoryProvider(repositoryProvider)
                        .build()
            }
        }
    }
}