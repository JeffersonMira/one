package com.onechurch.process.persistence.springjpa;

import com.onechurch.process.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by dc-user on 4/20/2017.
 */

/**
 * JPA have all the methods of MVC repository and Pagging.
 *
 * If you ar using CrudRepositories, it already create some 'endpoints':
 * create -> POST/Users
 * read -> GET/Users
 * UPDATE-> PUT/Users/<id> ou PATCH/Users/<id>
 * DELETE-> DELETE/users/<id>
 * It also creates a /search, where I can use the findByName. That is why I have that '@param'
 */

@RepositoryRestResource(exported = false) //not exposed
@Qualifier("userPersistance")
public interface UserPersistance extends JpaRepository<User, Long> {

    //@Query("select u from User u where u.name = ?")
    User findByUsername(/*@Param("name")*/ String username);
}
