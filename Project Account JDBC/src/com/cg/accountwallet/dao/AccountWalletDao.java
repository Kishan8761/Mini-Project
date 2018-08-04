package com.cg.accountwallet.dao;

import com.cg.accountwallet.bean.Account;
import com.cg.accountwallet.exception.AccountWalletException;

public interface AccountWalletDao {
	String createAccount(Account acc) throws AccountWalletException;
	double showBalance(String mobileNo) throws AccountWalletException;
	Account deposit(String mobileNo,double depAmount) throws AccountWalletException;
	Account withdraw(String mobileNo,double withdraw) throws AccountWalletException;
	Account printTransactionDetails(String mobileNo) throws AccountWalletException;

}
