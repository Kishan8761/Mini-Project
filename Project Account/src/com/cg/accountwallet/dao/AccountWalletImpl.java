package com.cg.accountwallet.dao;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.accountwallet.bean.Account;
import com.cg.accountwallet.db.AccountWalletDb;
import com.cg.accountwallet.exception.AccountWalletException;

public class AccountWalletImpl implements AccountWalletDao {
	private static HashMap<String, Account> paytmWalletMap = AccountWalletDb.getPaytmWalletMap();

	@Override
	public String createAccount(Account acc) throws AccountWalletException {
		// TODO Auto-generated method stub
		paytmWalletMap.put(acc.getMobileNo(), acc);
		return acc.getMobileNo();
	}

	@Override
	public double showBalance(String mobileNo) throws AccountWalletException {
		// TODO Auto-generated method stub
		Account a = paytmWalletMap.get(mobileNo);
		if (a == null) {
		throw new AccountWalletException("The mobile number does not exist");
		}
		return a.getBalance();
		}

	@Override
	public Account deposit(String mobileNo) throws AccountWalletException {
		// TODO Auto-generated method stub
		Account a = paytmWalletMap.get(mobileNo);
		if (a == null) {
		throw new AccountWalletException("The mobile number does not exist");
		}
		return a;
	}

	@Override
	public Account withdraw(String mobileNo) throws AccountWalletException {
		// TODO Auto-generated method stub
		Account a = paytmWalletMap.get(mobileNo);
		if (a == null) {
		throw new AccountWalletException("The mobile number does not exist");
		}
		return a;
	}

	@Override
	public Account printTransactionDetails(String mobileNo)
			throws AccountWalletException {
		// TODO Auto-generated method stub
		Account a = paytmWalletMap.get(mobileNo);
		if (a== null) {
		throw new AccountWalletException("The mobile number does not exist");
		}
		return a;
	}

	}


