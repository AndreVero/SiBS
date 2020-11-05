package com.vero.core.di

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import com.vero.core_db_impl.api.DataStorage
import com.vero.core_db_impl.impl.DataStorageImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ActivityRetainedComponent::class)
object StorageModule {

    @Provides
    fun provideDataStore(@ApplicationContext appContext: Context) : DataStore<Preferences>
            = appContext.createDataStore("data_store")

    @Provides
    fun provideDataStorage(dataStore: DataStore<Preferences>) : DataStorage
            = DataStorageImpl(dataStore)
}