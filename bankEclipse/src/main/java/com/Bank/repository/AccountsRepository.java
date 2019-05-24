package com.Bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Bank.model.Accounts;


public interface AccountsRepository extends JpaRepository<Accounts, Long>{

}
