package com.example.myapplication.di


import com.example.myapplication.domain.repository.ElementsRepository
import com.example.myapplication.data.repository.ElementsRepositoryImpl
import com.example.myapplication.domain.repository.RemoteElemDataSource
import com.example.myapplication.data.repository.RemoteElemDataSourceImpl
import com.example.myapplication.ui.element_list.SearchViewModel
import com.example.myapplication.ui.element_detail.DetailsViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModelOf

val AppModule = module {
    viewModelOf(::SearchViewModel)
    viewModelOf(::DetailsViewModel)

    singleOf(::ElementsRepositoryImpl) bind ElementsRepository::class
    singleOf(::RemoteElemDataSourceImpl) bind RemoteElemDataSource::class
}
