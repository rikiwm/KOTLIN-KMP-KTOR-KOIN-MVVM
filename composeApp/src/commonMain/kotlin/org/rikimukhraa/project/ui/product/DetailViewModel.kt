package org.rikimukhraa.project.screen.detail

import androidx.lifecycle.ViewModel
import org.rikimukhraa.project.domain.Repository

class DetailViewModel(private val repo: Repository) : ViewModel() {
    init {
        println("DetailViewModel")
    }

    override fun onCleared() {
        super.onCleared()
        println("DetailViewModel")
    }
}