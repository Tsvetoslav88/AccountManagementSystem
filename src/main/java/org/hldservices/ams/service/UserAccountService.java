package org.hldservices.ams.service;

import java.util.List;

import org.hldservices.ams.entity.UserAccount;

public interface UserAccountService {
	
	public List<UserAccount> findAll();
	
	public UserAccount findById(int theId);
	
	public void save(UserAccount theUserAccount);
	
	public void deleteById(int theId);
}
