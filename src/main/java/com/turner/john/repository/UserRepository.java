package com.turner.john.repository;

import org.springframework.data.repository.CrudRepository;

import com.turner.john.beans.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
