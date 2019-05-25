package org.hldservices.ams.service;

import java.util.List;
import java.util.Optional;

import org.hldservices.ams.dao.UserAccountRepository;
import org.hldservices.ams.entity.UserAccount;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	private UserAccountRepository userAccountRepository;
	
	@Override
	public List<UserAccount> findAll() {
		return userAccountRepository.findAllByOrderByFirstNameAsc();
	}

	@Override
	public UserAccount findById(int theId) {
		Optional<UserAccount> result = userAccountRepository.findById(theId);
		
		if(!result.isPresent()) {
			throw new RuntimeException("Did not find user account id: " + theId);
		}
		
		return  result.get();
	}

	@Override
	public void save(UserAccount theUserAccount) {
		userAccountRepository.save(theUserAccount);
	}

	@Override
	public void deleteById(int theId) {
		userAccountRepository.deleteById(theId);

	}

}
