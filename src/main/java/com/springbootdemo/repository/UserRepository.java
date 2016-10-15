package com.springbootdemo.repository;

import com.springbootdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
    User findById(@Param("id") Integer pId);

    List<User> findByAgeIn(@Param("ages") Collection<Integer> ages);

    List<User> findByNameIgnoreCase(@Param("name") String name);

    List<User> findByNameContains(@Param("name") String partialName);

    List<User> findAllByOrderByAgeDesc();


}