package com.vero.core_network_impl

import com.vero.core.model.Product

interface ProductRepository {
    suspend fun fetchProducts() : List<Product>
}