package org.hldservices.ams.utils;

import java.text.SimpleDateFormat;

import org.hldservices.ams.dao.UserAccountRepository;
import org.hldservices.ams.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

	private UserAccountRepository userAccountRepository;

    @Autowired
    public DataLoader(UserAccountRepository theUserAccountRepository) {
        this.userAccountRepository = theUserAccountRepository;
    }
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		userAccountRepository.save(new UserAccount(1,"Ivan", "Ivanov", "Ivan.Ivanov@gmail.com", new SimpleDateFormat("yyyy-MM-dd").parse("1993-10-05")));
		userAccountRepository.save(new UserAccount(2,"Dimitar", "Elenkov", "Dimitar.Elenkov@gmail.com", new SimpleDateFormat("yyyy-MM-dd").parse("1988-07-05")));
		userAccountRepository.save(new UserAccount(3,"Stanimir", "Dimitrov", "Stanimir.Dimitrov@gmail.com", new SimpleDateFormat("yyyy-MM-dd").parse("1693-01-15")));

	}

}
