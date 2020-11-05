package com.vero.core_db_impl.impl

import android.util.Log
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import com.vero.core_db_impl.api.DataStorage
import com.vero.core_db_impl.model.User

class DataStorageImpl(private val dataStore : DataStore<Preferences>) : DataStorage {

    companion object {
        val NAME = preferencesKey<String>("name")
        val PHONE = preferencesKey<String>("phone")
    }

    override suspend fun saveUser(user: User) {
        dataStore.edit { userStore ->
            userStore[NAME] = user.username
            userStore[PHONE] = user.phone
        }
    }
}