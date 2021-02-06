package com.tavant.accountrestapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.accountrestapi.exception.AccountIdIsNullException;
import com.tavant.accountrestapi.exception.NoDataFoundException;
import com.tavant.accountrestapi.exception.NotFoundException;
import com.tavant.accountrestapi.model.Account;
import com.tavant.accountrestapi.repository.AccountRepository;

@RestController
@RequestMapping("/api/account")
public class AccountController 
{
	@Autowired
	AccountRepository accountRepository;
	@GetMapping
	public String getAccount() 
	{
		return "welcome";
	}
	@GetMapping("/all")
	public List<Account> getAllAccounts() throws NoDataFoundException
	{
		List<Account> list = this.accountRepository.findAll();
        return Optional.ofNullable(
                list.isEmpty() ? null : list
                ).orElseThrow(()-> new NoDataFoundException("no record found"));
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable("id") String id) throws NotFoundException
	{
		Optional<Account> optional=accountRepository.findById(id);
		if(optional.isPresent())
		{
			return ResponseEntity.ok(optional.get());
		}
		else
		{
			throw new NotFoundException("record not found");
		}
	}
	@PostMapping
	public Account addAccount(@RequestBody @Valid Account account) throws AccountIdIsNullException
	{
		return accountRepository.save(account);
	}
    @DeleteMapping("/{id}")
    public String deleteAccountById(@PathVariable("id") String id) throws NotFoundException
	{
		Optional<Account> optional=accountRepository.findById(id);
		if(optional.isPresent())
		{
			accountRepository.deleteById(id);
			return "account deleted";
		}
		else
		{
			throw new NotFoundException("Id not found");
		}
	}
    @PostMapping("/{id}")
    public Account updateAccount(@PathVariable("id") String id,@Valid @RequestBody Account account) throws NotFoundException
	{
    	Account acc=accountRepository.findById(id).orElseThrow(()->new NotFoundException("Record Not Found"));
    	acc.setFirstName(account.getFirstName());
    	acc.setLastName(account.getLastName());
    	acc.setAccountType(account.getAccountType());
    	return accountRepository.save(acc);
	}
}
