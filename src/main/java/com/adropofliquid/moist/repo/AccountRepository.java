package com.adropofliquid.moist.repo;


import com.adropofliquid.moist.model.Account;
import org.springframework.data.repository.CrudRepository;


public interface AccountRepository extends CrudRepository<Account, Integer> {

    Account findByUserId(int userid);
}
