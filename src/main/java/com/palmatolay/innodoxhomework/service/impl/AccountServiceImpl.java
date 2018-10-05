package com.palmatolay.innodoxhomework.service.impl;

import com.palmatolay.innodoxhomework.model.Account;
import com.palmatolay.innodoxhomework.repository.AccountRepository;
import com.palmatolay.innodoxhomework.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account getById(Long id) {
		return accountRepository.getOne(id);
	}

	@Override
	public Account getByUsername(String username) {
		return accountRepository.findByUsername(username);
	}

	@Override
	public Account getByEmail(String email) {
		return accountRepository.findByEmail(email);
	}

	@Override
	public Collection<Account> getAll() {
		return accountRepository.findAll();
	}

	@Override
	public Boolean delete(Long id) {
		accountRepository.delete(getById(id));
		return !accountRepository.existsById(id);
	}
}
