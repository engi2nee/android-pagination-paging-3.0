package com.c_od_e.pagination.model

sealed class CatListItem {
    data class CatItem(val cat: Cat) : CatListItem()
    data class SeparatorItem(val letter: String) : CatListItem()
}