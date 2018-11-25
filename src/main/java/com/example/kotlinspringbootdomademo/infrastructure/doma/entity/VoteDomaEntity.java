package com.example.kotlinspringbootdomademo.infrastructure.doma.entity;

import org.seasar.doma.*;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
@Table(name = "vote")
public class VoteDomaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String voter;

    public String candidate;
}
