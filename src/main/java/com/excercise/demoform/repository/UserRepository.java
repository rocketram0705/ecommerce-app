package com.excercise.demoform.repository;

import org.springframework.data.repository.CrudRepository;

import com.excercise.demoform.model.UserData;

public interface UserRepository extends CrudRepository<UserData, Long> {
    
}
