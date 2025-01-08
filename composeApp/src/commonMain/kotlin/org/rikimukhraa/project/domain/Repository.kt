package org.rikimukhraa.project.domain

import org.rikimukhraa.project.data.model.Product

interface Repository {
    fun getProduct(): kotlinx.coroutines.flow.Flow<List<Product>>
}