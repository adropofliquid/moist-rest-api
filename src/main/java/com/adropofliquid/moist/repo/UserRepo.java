package com.adropofliquid.moist.repo;

import com.adropofliquid.moist.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepo extends CrudRepository<Users, Integer> {

    Users findByUsername(String username);

}
