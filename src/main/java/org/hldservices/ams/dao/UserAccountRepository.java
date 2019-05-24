package org.hldservices.ams.dao;

import java.util.List;

import org.hldservices.ams.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer>{
	
	public List<UserAccount> findAllByOrderByFirstNameAsc();
}
