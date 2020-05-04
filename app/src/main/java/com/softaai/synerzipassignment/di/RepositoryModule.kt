package com.softaai.synerzipassignment.di

import com.softaai.synerzipassignment.repository.MainRepository
import org.koin.dsl.module


val repositoryModule = module {
    single { MainRepository(get(), get()) }
}