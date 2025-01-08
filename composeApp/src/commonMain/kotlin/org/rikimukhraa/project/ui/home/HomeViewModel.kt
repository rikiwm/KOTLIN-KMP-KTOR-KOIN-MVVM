package org.rikimukhraa.project.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.rikimukhraa.project.data.model.Product
import org.rikimukhraa.project.domain.Repository

class HomeViewModel(private val repo: Repository):ViewModel() {
    private   val _products = MutableStateFlow<List<Product>>(listOf())
    val products: StateFlow<List<Product>> = _products.asStateFlow()

    init {
        viewModelScope.launch {
            repo.getProduct().collect { products ->
                try {
                    _products.update { it + products }
                } catch (e: Exception) {
//                    return@collect
                }
            }
        }
        println("HomeViewModel")
    }

    override fun onCleared() {
        super.onCleared()
        println("HomeViewModel")
    }
}