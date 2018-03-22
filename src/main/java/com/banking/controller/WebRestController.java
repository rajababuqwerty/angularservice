package com.banking.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping({"/api"})
public class WebRestController {
	
	
	public void setDummyValues() {
		userRepository.deleteAll();
		accountRepository.deleteAll();
		
		AccountDetails accountDetails = new AccountDetails();
		accountDetails.setAccountNumber("1234");
		accountDetails.setAmount(1111111);
		AccountDetails accountDetails1 = new AccountDetails();
		accountDetails1.setAccountNumber("6789");
		accountDetails1.setAmount(2222222);
		User user = new User();
		user.setUser("BBBBBB");
		user.setAccountNumber("1234");
		user.setTypeOfUser("user");
		User user1 = new User();	
		user1.setUser("AAAAAAA");
		user1.setAccountNumber("6789");
		user1.setTypeOfUser("user");
		userRepository.save(user);
		userRepository.save(user1);
		accountRepository.save(accountDetails1);
		accountRepository.save(accountDetails);
		
		AccountDetails accountDetails2 = new AccountDetails();
		accountDetails2.setAccountNumber("9876");
		accountDetails2.setAmount(3333333);
		AccountDetails accountDetails3 = new AccountDetails();
		accountDetails3.setAccountNumber("4321");
		accountDetails3.setAmount(444444);
		User user2 = new User();
		user2.setUser("CCCCCCC");
		user2.setAccountNumber("4321");
		user2.setTypeOfUser("admin");
		User user3 = new User();	
		user3.setUser("DDDDDD");
		user3.setAccountNumber("9876");
		user3.setTypeOfUser("admin");
		userRepository.save(user2);
		userRepository.save(user3);
		accountRepository.save(accountDetails2);
		accountRepository.save(accountDetails3);
		
		
	}
	@Autowired 
    private UserRepository userRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	
	@GetMapping
	public ArrayList<User> getUser() {
		setDummyValues();
		return (ArrayList<User>) userRepository.findUsersBasedOnType("user");
		
	}
	
	@PostMapping
	public ArrayList<AccountDetails> updateUser(@RequestBody UserDetails userDetails) {
		AccountDetails fromAccountDetails = accountRepository.findOne(userDetails.getFromAccountNumber());
		AccountDetails toAccountDetails = accountRepository.findOne(userDetails.getToAccountNumber());
		int fromUserAmount = fromAccountDetails.getAmount();
		int toUserAmount = toAccountDetails.getAmount();
		int updatedFromAmount = fromUserAmount - userDetails.getAmount();
		int toFromAmount = toUserAmount + userDetails.getAmount();
		fromAccountDetails.setAmount(updatedFromAmount);
		fromAccountDetails.setRemarks(userDetails.getRemarks());
		toAccountDetails.setAmount(toFromAmount);
		toAccountDetails.setRemarks(userDetails.getRemarks());
		accountRepository.save(fromAccountDetails);
		accountRepository.save(toAccountDetails);
		return (ArrayList<AccountDetails>) accountRepository.findAll();
	}
	
	@GetMapping(value="/{admin}")
	public ArrayList<User> getAdminUser() {
		setDummyValues();
		User user = new User();
		user.setTypeOfUser("admin");
		return (ArrayList<User>) userRepository.findUsersBasedOnType(user.getTypeOfUser());
		
	}
}
