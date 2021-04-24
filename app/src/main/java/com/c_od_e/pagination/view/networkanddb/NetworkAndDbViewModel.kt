package com.c_od_e.pagination.view.networkanddb

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import com.c_od_e.pagination.core.BaseViewModel
import com.c_od_e.pagination.data.CatsRepository
import kotlinx.coroutines.launch

@ExperimentalPagingApi
class NetworkAndDbViewModel @ViewModelInject constructor(private val repository: CatsRepository) :
    BaseViewModel() {

    init {
        viewModelScope.launch {
            repository.deleteDummyData()
        }
    }

    override val dataSource = repository.getCatsFromMediator()
}
