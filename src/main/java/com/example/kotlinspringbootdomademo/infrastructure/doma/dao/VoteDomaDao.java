package com.example.kotlinspringbootdomademo.infrastructure.doma.dao;

import com.example.kotlinspringbootdomademo.infrastructure.doma.entity.VoteDomaEntity;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.*;

import java.util.List;

@ConfigAutowireable
@Dao
public interface VoteDomaDao {
    @Select
    List<VoteDomaEntity> selectAll();

    @Insert
    int insert(VoteDomaEntity entity);

    @Update
    int update(VoteDomaEntity entity);

    @Select
    VoteDomaEntity selectById(int id);

    @Delete
    int delete(VoteDomaEntity entity);
}