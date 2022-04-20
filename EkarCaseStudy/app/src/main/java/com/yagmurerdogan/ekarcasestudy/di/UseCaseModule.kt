package com.yagmurerdogan.ekarcasestudy.di

import com.yagmurerdogan.ekarcasestudy.data.repository.CarRepository
import com.yagmurerdogan.ekarcasestudy.domain.mapper.CarSpecUIModelMapper
import com.yagmurerdogan.ekarcasestudy.domain.usecase.CarDetail
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideCarDetailUseCase(
        repository: CarRepository,
        mapper: CarSpecUIModelMapper
    ) = CarDetail(repository, mapper)

}