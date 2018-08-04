package com.cg.accountwallet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.accountwallet.bean.Account;
import com.cg.accountwallet.exception.AccountWalletException;

public class AccountWalletDb {
	public static Connection getConnection() throws AccountWalletException{
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	return DriverManager.getConnection(url,"system","orcl11g");
	}catch(ClassNotFoundException e){
	throw new AccountWalletException(e.getMessage());
	}catch(SQLException e1){
	throw new AccountWalletException(e1.getMessage());
	}
	 
	 
	}

}
