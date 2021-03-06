package com.egoriku.settings.presentation

import com.egoriku.ui.arch.pvm.BaseContract

interface SettingsPageContract {

    interface View : BaseContract.View {

    }

    interface Presenter : BaseContract.Presenter<View> {

        fun loadLandingData()
    }
}