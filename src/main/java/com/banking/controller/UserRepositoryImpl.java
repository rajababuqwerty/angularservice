package com.banking.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;



public class UserRepositoryImpl implements CustomUserRepository {
	 
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> findUsersBasedOnType(String typeOfUser) {
		 Query query = entityManager.createNativeQuery("SELECT * FROM User WHERE type_Of_User = ?" , User.class);
	        query.setParameter(1, typeOfUser);
		return  query.getResultList();
		
	}
}
