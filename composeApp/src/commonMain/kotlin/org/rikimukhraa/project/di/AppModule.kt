package org.rikimukhraa.project.di

import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.rikimukhraa.project.data.repository.AppRepository
import org.rikimukhraa.project.domain.Repository
import org.rikimukhraa.project.screen.detail.DetailViewModel
import org.rikimukhraa.project.screen.home.HomeViewModel
import org.rikimukhraa.project.ui.auth.FirebaseAuthManager

val appMode = module {
    single<Repository> { AppRepository() }
single { FirebaseAuthManager() }
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}

fun  iniistializeKoin(){
    startKoin {
        modules(appMode)
    }
}