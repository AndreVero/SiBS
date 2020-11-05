package com.vero.core_db_impl.api

import com.vero.core_db_impl.model.User

interface DataStorage {
    suspend fun saveUser(user: User)
}