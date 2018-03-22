package com.banking.controller;

import java.util.List;

public interface CustomUserRepository {
	public List<User> findUsersBasedOnType(String typeOfUser);
}
