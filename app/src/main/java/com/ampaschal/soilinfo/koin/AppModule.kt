package com.ampaschal.soilinfo.koin

import com.ampaschal.soilinfo.MainViewModel
import com.ampaschal.soilinfo.data.DefaultPlacesRepository
import com.ampaschal.soilinfo.data.PlacesRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<PlacesRepository> { DefaultPlacesRepository() }
    viewModel { MainViewModel(get()) }
}