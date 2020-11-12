package com.vero.sibs.fake

import com.vero.core.model.User
import com.vero.core_db_impl.api.LocalStorage

class FakeLocalStorage : LocalStorage {
    override suspend fun saveUser(user: User)  = true
}