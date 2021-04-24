package com.c_od_e.pagination.view.db

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import com.c_od_e.pagination.core.BaseViewModel
import com.c_od_e.pagination.data.CatsRepository
import com.c_od_e.pagination.model.Cat
import kotlinx.coroutines.launch

@ExperimentalPagingApi
class DataBaseViewModel @ViewModelInject constructor(private val repository: CatsRepository) :
    BaseViewModel() {

    override val dataSource = repository.getCatsFromDb()

    fun fillWithDummyCats() {
        val dummyCats = mutableListOf<Cat>()
        for (i in 0..10000) {
            dummyCats.add(Cat(i.toString(), "https://cdn2.thecatapi.com/images/ja.jpg"))
        }
        viewModelScope.launch {
            repository.fillWithDummyCats(dummyCats)
        }
    }
}