package com.c_od_e.pagination.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class RemoteKey(
    @PrimaryKey val catId: String,
    val prevKey: Int?,
    val nextKey: Int?
)
