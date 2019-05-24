package com.Bank.service;

import java.util.List;

import com.Bank.model.Accounts;

public interface AccountsService {
	public Accounts createAccount(Accounts accounts);
	
	public List<Accounts> getAccounts();
	
	public Accounts getAccount(long id);
	
	public Accounts updateAccount(Accounts accounts);
	
	public Accounts deleteAccount(Long id);
}
