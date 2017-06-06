package com.stackroute.ng2boot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.ng2boot.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
