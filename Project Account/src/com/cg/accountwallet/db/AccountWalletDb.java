package com.cg.accountwallet.db;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.accountwallet.bean.Account;

public class AccountWalletDb {
	private static HashMap<String,Account> paytmWalletDb=new HashMap<String,Account>();
	public static HashMap<String, Account> getPaytmWalletMap() {
	return paytmWalletDb;
	}
	Account o= new Account();
	static{
	 
	paytmWalletDb.put("7981123927",new Account("7981123927","Prasad","Prasad777@gmail.com",5000.0,LocalDateTime.now()));
	paytmWalletDb.put("9949565567",new Account("9949565567","Kishan","kishan@gmail.com",6000.0,LocalDateTime.now()));
	paytmWalletDb.put("8309963649",new Account("8309963649","Chandu","chandu@gmail.com",2000.0,LocalDateTime.now()));
	paytmWalletDb.put("9059849344",new Account("9059849344","Varma","varma@gmail.com",1000.0,LocalDateTime.now()));
	}

}
