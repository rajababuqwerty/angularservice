package com.banking.controller;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountDetails, String> {


}
