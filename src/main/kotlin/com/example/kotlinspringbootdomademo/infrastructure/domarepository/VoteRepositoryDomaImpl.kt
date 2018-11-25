package com.example.kotlinspringbootdomademo.infrastructure.domarepository

import com.example.kotlinspringbootdomademo.domain.model.Vote
import com.example.kotlinspringbootdomademo.domain.repository.VoteRepository
import com.example.kotlinspringbootdomademo.infrastructure.doma.dao.VoteDomaDao
import com.example.kotlinspringbootdomademo.infrastructure.doma.entity.VoteDomaEntity
import org.springframework.stereotype.Repository

@Repository
class VoteRepositoryDomaImpl(
        private val voteDomaDao: VoteDomaDao
): VoteRepository {
    override fun findAll(): List<Vote> {
        return voteDomaDao.selectAll().map { _mapToModel(it) }
    }

    override fun findById(id: Int): Vote? {
        return voteDomaDao.selectById(id)?.let { _mapToModel(it) }
    }

    override fun create(vote: Vote): Int {
        val domaEntity = _mapToDomaEntity(vote)
        voteDomaDao.insert(domaEntity)
        return domaEntity.id
    }

    override fun update(vote: Vote) {
        val domaEntity = _mapToDomaEntity(vote)
        voteDomaDao.update(domaEntity)
    }

    override fun delete(vote: Vote) {
        val domaEntity = _mapToDomaEntity(vote)
        voteDomaDao.delete(domaEntity)
    }

    // ここでDomaのEntity（Java）をドメインのModel（Kotlin）に詰め替える
    private fun _mapToModel(domaEntity: VoteDomaEntity): Vote {
        return Vote(
                id = domaEntity.id,
                voter_id = domaEntity.voter_id,
                candidate_id = domaEntity.candidate_id
        )
    }

    // ここでドメインのModel（Kotlin）をDomaのEntity（Java）をに詰め替える
    private fun _mapToDomaEntity(vote: Vote): VoteDomaEntity {
        return VoteDomaEntity().also {
            it.id = vote.id
            it.voter_id = vote.voter_id
            it.candidate_id = vote.candidate_id
        }
    }
}
