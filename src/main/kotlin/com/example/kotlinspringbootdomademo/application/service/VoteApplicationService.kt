package com.example.kotlinspringbootdomademo.application.service

import com.example.kotlinspringbootdomademo.application.RecordNotFoundException
import com.example.kotlinspringbootdomademo.application.input.VoteInput
import com.example.kotlinspringbootdomademo.domain.model.Vote
import com.example.kotlinspringbootdomademo.domain.repository.VoteRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class VoteApplicationService(
        private val voteRepository: VoteRepository
) {
    fun findAll(): List<Vote> {
        return voteRepository.findAll()
    }

    fun findById(id: Int): Vote {
        return voteRepository.findById(id) ?: throw RecordNotFoundException()
    }

    fun create(voteInput: VoteInput): Int {
        val vote = Vote(
                voter = voteInput.voter!!,
                candidate = voteInput.candidate!!
        )

        return voteRepository.create(vote)
    }

    fun update(id: Int, voteInput: VoteInput) {
        val existingVote = voteRepository.findById(id) ?: throw RecordNotFoundException()

        val vote = existingVote.copy(
                voter = voteInput.voter!!,
                candidate = voteInput.candidate!!
        )

        voteRepository.update(vote)
    }

    fun delete(id: Int) {
        val vote = voteRepository.findById(id) ?: throw RecordNotFoundException()
        voteRepository.delete(vote)
    }

    
}
