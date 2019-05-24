package com.Bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Bank.model.Accounts;
import com.Bank.service.AccountsService;


@RestController
@RequestMapping("api/v1/")
public class AccountsController {
	@Autowired
	private AccountsService accountsService;
	
	@RequestMapping(value = "accounts/list", method = RequestMethod.GET)
	public List<Accounts> list(){
		return accountsService.getAccounts();
	}
	
	@RequestMapping(value = "accounts/account", method = RequestMethod.POST)
	public Accounts create(@RequestBody Accounts accounts) {
		return accountsService.createAccount(accounts);
	}
	
	@RequestMapping(value = "accounts/{id}", method = RequestMethod.GET)
    public Accounts get(@PathVariable Long id){
        return accountsService.getAccount(id).getMoney();
    }
	
	@RequestMapping(value = "accounts/{id}", method = RequestMethod.PUT)
    public Accounts update(@PathVariable Long id, @RequestBody Accounts accounts){		
        return accountsService.updateAccount(accounts);
    }
	
	@RequestMapping(value = "accounts/{id}", method = RequestMethod.DELETE)
    public Accounts delete(@PathVariable Long id){
		return accountsService.deleteAccount(id);
    }

}
