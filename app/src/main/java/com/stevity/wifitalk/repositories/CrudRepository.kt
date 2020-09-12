package com.stevity.wifitalk.repositories

import androidx.lifecycle.LiveData

interface CrudRepository<T> {
    fun findAll(): LiveData<List<T>>
    fun findById(id: Long): T
    fun save(t: T)
    fun update(t: T)
    fun delete(t: T)
}