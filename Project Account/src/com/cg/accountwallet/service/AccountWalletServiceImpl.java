package com.cg.accountwallet.service;

import java.time.LocalDateTime;
import java.util.HashMap;











import com.cg.accountwallet.bean.Account;
import com.cg.accountwallet.dao.AccountWalletDao;
import com.cg.accountwallet.dao.AccountWalletImpl;
import com.cg.accountwallet.db.AccountWalletDb;
import com.cg.accountwallet.exception.AccountWalletException;

public class AccountWalletServiceImpl implements AccountWalletService {
	AccountWalletDao dao = new AccountWalletImpl();
	
	@Override
	public String createAccount(Account a) throws AccountWalletException {
		// TODO Auto-generated method stub

	    
		if (a.getName().isEmpty() || a.getName() == null) {
			throw new AccountWalletException("Name cannot be empty");
			}
		else {
		if (!a.getName().matches("[A-Z][A-Za-z]{2,}")) {
			throw new AccountWalletException("Name should start with capital letter and should contain only alphabets");
			}
			}
		
	    if (!a.getMobileNo().matches("\\d{10}")) {
	    	throw new AccountWalletException("Mobile number should contain 10 digits");
	    	}
	    if (a.getEmail().matches("[a-z0-9]+@[a-z]+\\.com")) {
			throw new AccountWalletException("Enter valid emailid");
			}
	    return dao.createAccount(a);
	
	}

	@Override
	public double showBalance(String mobileNo) throws AccountWalletException {
		// TODO Auto-generated method stub
		if (!mobileNo.matches("\\d{10}")) {
			throw new AccountWalletException("Mobile number should contain 10 digits");
			}
		return dao.showBalance(mobileNo);
	
	}

	@Override
	public Account deposit(String mobileNo, double depositAmount)
			throws AccountWalletException {
		// TODO Auto-generated method stub
		if (!mobileNo.matches("\\d{10}")) {
			throw new AccountWalletException("Mobile number should contain 10 digits");
			}
			Account a = dao.deposit(mobileNo);
			if (depositAmount <= 0) {
			throw new AccountWalletException("Deposit amount must be greater than zero");
			}
			a.setBalance(a.getBalance() + depositAmount);
			a.setDate(LocalDateTime.now());
		return a;
	}

	@Override
	public Account withdraw(String mobileNo, double withdrawAmount)
			throws AccountWalletException {
		// TODO Auto-generated method stub
		if (!mobileNo.matches("\\d{10}")) {
			throw new AccountWalletException("Mobile number should contain 10 digits");
			}
			Account a = dao.withdraw(mobileNo);
			if (withdrawAmount > a.getBalance() || withdrawAmount <= 0) {
			throw new AccountWalletException(
			"The amount to be withdrawn should be greater than available balance and greater than zero");
			}
			a.setBalance(a.getBalance() - withdrawAmount);
			a.setDate(LocalDateTime.now());
		return a;
		
	}

	@Override
	public boolean fundTransfer(String sourceMobileNo, String destinationMobileNo,
			double transferAmount) throws AccountWalletException {
		// TODO Auto-generated method stub
		if (!sourceMobileNo.matches("\\d{10}")) {
			throw new AccountWalletException("Mobile number should contain 10 digits");
			}
			if (!destinationMobileNo.matches("\\d{10}")) {
			throw new AccountWalletException("Mobile number should contain 10 digits");
			}
			AccountWalletService service = new AccountWalletServiceImpl();
			Account a1 = service.withdraw(sourceMobileNo, transferAmount);
			Account a2 = service.deposit(destinationMobileNo, transferAmount);
			return false;
	}

	@Override
	public Account printTransactionDetails(String mobileNo)
			throws AccountWalletException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new AccountWalletException("Mobile number should contain 10 digits");
			}
		return dao.printTransactionDetails(mobileNo);
	}
}


