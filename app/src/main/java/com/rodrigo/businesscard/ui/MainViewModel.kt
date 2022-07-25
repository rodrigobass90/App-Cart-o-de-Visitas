package com.rodrigo.businesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
Class MainViewModel(private val businessCardRepository: BusinessCardrepository : ViewModel() {

    fun insert(businessCard: BusinessCard) {
        BusinessCardrepository,insert(businessCard)
    }

    fun getAll() : LiveData<List<BusinessCard>> {
        return businessCardrepository.getAll

    }

}

class MainViewModelFactory(private val repository: BusinessCardrepository):
    viewModelProvider.Factory {
    override fun <T : viewModel?> create(modelclass: class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress(...names "UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }

        THROW IllegalArgumentException("unknow viewModel class")
    }

}
