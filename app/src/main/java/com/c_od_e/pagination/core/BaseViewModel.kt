package com.c_od_e.pagination.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.insertSeparators
import androidx.paging.map
import com.c_od_e.pagination.model.Cat
import com.c_od_e.pagination.model.CatListItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

abstract class BaseViewModel : ViewModel() {
    abstract val dataSource: Flow<PagingData<Cat>>


    val cats: Flow<PagingData<CatListItem>> by lazy {
        dataSource
            .map { pagingData -> pagingData.map { CatListItem.CatItem(it) } }
            .map {
                it.insertSeparators { before, after ->
                    if (after == null) {
                        return@insertSeparators null
                    }

                    val nameOfAfterItem = after.cat.id.first().toString()

                    if (before == null) {
                        return@insertSeparators CatListItem.SeparatorItem(
                            nameOfAfterItem,
                        )
                    }

                    val nameOfBeforeItem = before.cat.id.first().toString()
                    if (nameOfBeforeItem != nameOfAfterItem) {
                        return@insertSeparators CatListItem.SeparatorItem(
                            nameOfAfterItem
                        )
                    } else {
                        null
                    }
                }
            }.cachedIn(viewModelScope)
    }
}