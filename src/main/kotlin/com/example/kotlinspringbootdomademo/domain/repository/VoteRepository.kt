package com.example.kotlinspringbootdomademo.domain.repository

import com.example.kotlinspringbootdomademo.domain.model.Vote

interface VoteRepository {
    fun findAll(): List<Vote>
    fun findById(id: Int): Vote?
    fun create(vote: Vote): Int
    fun update(vote: Vote)
    fun delete(vote: Vote)
}
