package com.c_od_e.pagination.view.network

import androidx.hilt.lifecycle.ViewModelInject
import androidx.paging.ExperimentalPagingApi
import com.c_od_e.pagination.core.BaseViewModel
import com.c_od_e.pagination.data.CatsRepository

@ExperimentalPagingApi
class NetworkOnlyViewModel @ViewModelInject constructor(private val repository: CatsRepository) :
    BaseViewModel() {
    override val dataSource = repository.getCatsFromNetwork()
}