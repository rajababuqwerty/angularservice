/**
 * 
 */
package com.banking.controller;
import org.springframework.data.repository.CrudRepository;
/**
 * @author Raja Babu
 *
 */
public interface UserRepository extends  CrudRepository<User, Long>,CustomUserRepository {
	 

}
