package com.palmatolay.innodoxhomework.service;

import com.palmatolay.innodoxhomework.model.Account;

import java.util.Collection;

/**
 * Part of the service layer what responsible for the account related communication between the persistence and the web layer.
 */
public interface AccountService {
	Account save(Account account);
	Account getById(Long id);
	Account getByUsername(String username);
	Account getByEmail(String email);
	Collection<Account> getAll();

	/**
	 * @param id refer to an exists account in the database
	 * @return true if the deletion was successful, otherwise return false if the account still exists in the database
	 */
	Boolean delete(Long id);
}
