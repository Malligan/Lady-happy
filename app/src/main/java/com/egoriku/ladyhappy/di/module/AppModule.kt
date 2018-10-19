package com.egoriku.ladyhappy.di.module

import com.egoriku.core.IApplication
import com.egoriku.core.di.ApplicationScope
import com.egoriku.core.di.utils.IAnalyticsHelper
import com.egoriku.core.di.utils.IFirebaseFirestore
import com.egoriku.ladyhappy.tools.AnalyticsHelper
import com.egoriku.ladyhappy.tools.FirebaseFirestore
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    @ApplicationScope
    fun provideFirebaseFirestore(): IFirebaseFirestore = FirebaseFirestore()

    @Provides
    @ApplicationScope
    fun provideAnalyticsHelper(app: IApplication): IAnalyticsHelper = AnalyticsHelper(app.getApplicationContext())
}