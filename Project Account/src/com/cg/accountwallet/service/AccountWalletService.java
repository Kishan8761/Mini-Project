package com.cg.accountwallet.service;

import com.cg.accountwallet.bean.Account;
import com.cg.accountwallet.exception.AccountWalletException;

public interface AccountWalletService {
	String createAccount(Account acc) throws AccountWalletException;
	double showBalance(String mobileNo) 
			throws AccountWalletException;
	Account deposit(String mobileNo,double depositAmount) throws AccountWalletException;
	Account withdraw(String mobileNo,double withdrawAmount) throws AccountWalletException;
	boolean fundTransfer(String sourceMobileNo,String destinationMobileNo,double transferAmount)
			throws AccountWalletException;
	Account printTransactionDetails(String mobileNo) throws AccountWalletException;

}
