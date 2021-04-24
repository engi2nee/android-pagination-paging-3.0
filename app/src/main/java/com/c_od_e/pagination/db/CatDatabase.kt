package com.c_od_e.pagination.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.c_od_e.pagination.model.Cat

@Database(version = 1, entities = [Cat::class, RemoteKey::class])
abstract class CatDatabase : RoomDatabase() {
    abstract fun getCatDao(): CatDao
    abstract fun getKeysDao(): RemoteKeyDao
}