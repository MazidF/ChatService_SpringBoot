package com.example.mazidrestapi.repository

import com.example.mazidrestapi.model.Message

interface IRepository<T : Any> {
    fun create(t: T): T
    fun update(id: Long, t: T): Boolean
    fun delete(id: Long): Boolean
    fun findById(id: Long): Message?
    fun findAll(): List<T>
}