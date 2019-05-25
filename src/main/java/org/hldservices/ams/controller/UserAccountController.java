package org.hldservices.ams.controller;

import java.util.List;

import org.hldservices.ams.dao.UserAccountRepository;
import org.hldservices.ams.entity.UserAccount;
import org.hldservices.ams.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user-accounts")
public class UserAccountController {
	
	private final UserAccountService userAccountService;

    @Autowired
    public UserAccountController(UserAccountService theUserAccountService) {
        this.userAccountService = theUserAccountService;
    }
    
    @GetMapping("/list")
    public String listUserAccounts(Model theModel) {
    	
    	// Get User Accounts from DB
    	List<UserAccount> theUserAccounts = userAccountService.findAll();
    	
    	// Add to the Spring Model
    	theModel.addAttribute("userAccounts", theUserAccounts);
    	
    	return "useraccounts/list-user-accounts";
    }
    
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
    	
    	// create model attribute to bind form data
    	UserAccount theUserAccount = new UserAccount();
    	
    	theModel.addAttribute("userAccount", theUserAccount);
    	
    	return "useraccounts/user-account-form";
    }
    
    @PostMapping("/save")
    public String saveUserAccount(@ModelAttribute("userAccount") UserAccount theUserAccount) {
    	
    	// save the employee
    	userAccountService.save(theUserAccount);
    	
    	// use a redirect to prevent duplicate submissions
    	return "redirect:/user-accounts/list";
    	
    }
}
