package com.vero.sibs.fake

import com.vero.core.model.User
import com.vero.core_db_impl.api.DataStorage

class FakeDataStorage : DataStorage {
    override suspend fun saveUser(user: User) : Boolean {
        return true
    }
}