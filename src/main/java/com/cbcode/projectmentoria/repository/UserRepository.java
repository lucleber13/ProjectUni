package com.cbcode.projectmentoria.repository;

import com.cbcode.projectmentoria.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "select u from User u where u.login = ?1")
    User findUserByLogin(String login);

    @Query(value = "select u from User u where u.name = ?1")
    User findUserByName(String name);

    @Query(value = "select constraint_name from information_schema.constraint_column_usage where table_name = 'users_access' and column_name = 'access_id' and constraint_name <> 'unique_access_user';", nativeQuery = true)
    String checkConstraintAccess();

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into users_access(users_id, access_id) values (?1, (select id from access where description = 'ROLE_USER'))")
    void insertUserAccess(Long iduser);
}
