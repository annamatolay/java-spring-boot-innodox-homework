package com.palmatolay.innodoxhomework.repository;

import com.palmatolay.innodoxhomework.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Part of the persistence layer what can access and modify accounts in the database
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	Account findByEmail(String email);
	Account findByUsername(String userName);
}
