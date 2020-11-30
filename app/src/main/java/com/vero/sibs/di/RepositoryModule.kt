package com.vero.sibs.di

import com.vero.core_network_impl.ProductRepository
import com.vero.sibs.fake.FakeProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    fun provideProductRepository() : ProductRepository = FakeProductRepository()
}