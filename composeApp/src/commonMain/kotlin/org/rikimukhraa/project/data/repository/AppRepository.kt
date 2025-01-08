package org.rikimukhraa.project.data.repository

import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.flow
import org.rikimukhraa.project.data.model.Product
import org.rikimukhraa.project.domain.Repository
import org.rikimukhraa.project.domain.httpClient


class AppRepository: Repository {

    suspend fun  getProductApi(): List<Product> {
        val result = httpClient.get("https://fakestoreapi.com/products")
        println("Home = "+result.toString())
        return result.body()
    }
     override fun  getProduct() =  flow {
        emit(getProductApi())
    }

//
}