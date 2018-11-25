#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE kotlindemo;
EOSQL

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" kotlindemo <<-EOSQL
    BEGIN;

    create table customer (
        id serial,
        voter_id int,
        candidate_id int
    );

    insert into customer(voter_id, candidate_id) values (1,2);
    insert into customer(voter_id, candidate_id) values (2,3);
    insert into customer(voter_id, candidate_id) values (3,1);

    create table customer (
        id serial,
        name varchar(50),
        email varchar(50)
    );

    insert into customer(name, email) values ('hoge', 'hoge@example.com');
    insert into customer(name, email) values ('fuge', 'fuge@example.com');
    insert into customer(name, email) values ('piyo', 'piyo@example.com');

    COMMIT;
EOSQL
