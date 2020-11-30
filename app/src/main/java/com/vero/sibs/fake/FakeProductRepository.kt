package com.vero.sibs.fake

import com.vero.core.model.Product
import com.vero.core_network_impl.ProductRepository
import kotlinx.coroutines.delay

class FakeProductRepository : ProductRepository {
    override suspend fun fetchProducts() : List<Product> {
        delay(2000)
        return emptyList()
    }
}