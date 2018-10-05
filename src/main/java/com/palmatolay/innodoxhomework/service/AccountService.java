package com.palmatolay.innodoxhomework.service;

import com.palmatolay.innodoxhomework.model.Account;

import java.util.Collection;

public interface AccountService {
	Account save(Account account);
	Account getById(Long id);
	Account getByUsername(String username);
	Account getByEmail(String email);
	Collection<Account> getAll();
	Boolean delete(Long id);
}
