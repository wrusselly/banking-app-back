package com.Bank.service.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bank.model.Accounts;
import com.Bank.repository.AccountsRepository;
import com.Bank.service.AccountsService;

@Service
public class AccountsServiceImpl implements AccountsService{
	@Autowired
	private AccountsRepository accountsRepository;

	public Accounts createAccount(Accounts accounts) {
		return accountsRepository.saveAndFlush(accounts);
	}
	
	public List<Accounts> getAccounts(){
		return accountsRepository.findAll();
	}

	public Accounts getAccount(long id) {
		Accounts accounts = accountsRepository.findOne(id);
		return accounts;
	}
	
	public Accounts updateAccount(Accounts accounts) {
		Accounts existingAccount = accountsRepository.findOne(accounts.getId());
		BeanUtils.copyProperties(accounts, existingAccount);
		return accountsRepository.saveAndFlush(accounts);
	}
	
	public Accounts deleteAccount(Long id) {
		Accounts existingAccount = accountsRepository.findOne(id);
		accountsRepository.delete(existingAccount);
		return existingAccount;
	}
}
