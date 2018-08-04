package com.cg.accountwallet.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


import com.cg.accountwallet.bean.Account;
import com.cg.accountwallet.db.AccountWalletDb;
import com.cg.accountwallet.exception.AccountWalletException;

public class AccountWalletImpl implements AccountWalletDao {

	@Override
	public String createAccount(Account acc) throws AccountWalletException {
		Connection con=AccountWalletDb.getConnection();
		PreparedStatement stat;
		try{
		con.setAutoCommit(false);
		stat = con.prepareStatement(IQueryMapper.insert);
		stat.setString(1, acc.getName());
		stat.setString(2, acc.getEmail());
		stat.setString(3, acc.getMobileNo());
		stat.setDouble(4, acc.getBalance());
		int res=stat.executeUpdate();
		if(res==1){
		con.commit();
		return acc.getMobileNo();
		}else{
		throw new AccountWalletException("Could not create account");
		}
		 
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new AccountWalletException(e.getMessage());
		}
		 
	}

	@Override
	public double showBalance(String mobileNo) throws AccountWalletException {
		Connection con=AccountWalletDb.getConnection();
		
		PreparedStatement stat;
		try{
		stat=con.prepareStatement(IQueryMapper.getBal);
		stat.setString(1, mobileNo);
		ResultSet rs=stat.executeQuery();
		con.commit();
		if(rs!=null){
		rs.next();
		return rs.getDouble("balance");
		}else{
		throw new AccountWalletException("mobile no does not exists");
		}
		 
		}catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new AccountWalletException(e.getMessage());
		}
	}

	@Override
	public Account deposit(String mobileNo, double depAmount)
			throws AccountWalletException {
		Connection con=AccountWalletDb.getConnection();
		PreparedStatement stat;
		PreparedStatement stat1;
		try{
		 
		stat=con.prepareStatement(IQueryMapper.getacc);
		stat.setString(1, mobileNo);
		ResultSet rs=stat.executeQuery();
		if(rs!=null){
		rs.next();
		Account acc=new Account();
		double balance=rs.getDouble("balance")+depAmount;
		acc.setName(rs.getString("name"));
		acc.setMobileNo(rs.getString("mobileno"));
		acc.setBalance(balance);
		acc.setEmail(rs.getString("email"));
		acc.setDate(Date.valueOf(LocalDate.now()));
		//acc.setDate(LocalDateTime.now());
		//Account acc1=new Account();
		 
		stat1=con.prepareStatement(IQueryMapper.update);
		stat1.setDouble(1, acc.getBalance());
		stat1.setDate(2, acc.getDate());
		stat1.setString(3, acc.getMobileNo());
		int rs1=stat1.executeUpdate();
		 
		 
		if(rs1==1){
		 
		con.commit();
		 
		return acc;
		}else{
		throw new AccountWalletException("balance is not updated");
	}
		}
		else{
		throw new AccountWalletException("mobile no does not exists");
		}
		 
		 
		}catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new AccountWalletException(e.getMessage());
		}
	}

	@Override
	public Account withdraw(String mobileNo, double withdraw)
			throws AccountWalletException {
		Connection con=AccountWalletDb.getConnection();
		PreparedStatement stat;
		PreparedStatement stat1;
		try{
		 
		stat=con.prepareStatement(IQueryMapper.getacc);
		stat.setString(1, mobileNo);
		ResultSet rs=stat.executeQuery();
		if(rs!=null){
		rs.next();
		Account acc=new Account();
		double balance=rs.getDouble("balance")-withdraw;
		acc.setName(rs.getString("name"));
		acc.setMobileNo(rs.getString("mobileno"));
		acc.setBalance(balance);
		acc.setEmail(rs.getString("email"));
		acc.setDate(Date.valueOf(LocalDate.now()));
		//acc.setDate(LocalDateTime.now());
		//Account acc1=new Account();
		 
		stat1=con.prepareStatement(IQueryMapper.update);
		stat1.setDouble(1, acc.getBalance());
		stat1.setDate(2, acc.getDate());
		stat1.setString(3, acc.getMobileNo());
		int rs1=stat1.executeUpdate();
		 
		 
		if(rs1==1){
		//rs1.next();
		con.commit();
		//bal1=acc.getBalance();
		return acc;
		}else{
		throw new AccountWalletException("mobile no does not exists");
		}
		//return bal1;
		}
		else{
		throw new AccountWalletException("mobile no does not exists");
		}
		 
		 
		}catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new AccountWalletException(e.getMessage());
		}
		 
	}

	@Override
	public Account printTransactionDetails(String mobileNo)
			throws AccountWalletException {
		Connection con=AccountWalletDb.getConnection();
		PreparedStatement stat;
		try{
		stat=con.prepareStatement(IQueryMapper.getacc);
		stat.setString(1, mobileNo);
		ResultSet rs=stat.executeQuery();
		con.commit();
		if(rs!=null){
		rs.next();
		Account ac=new Account();
		ac.setName(rs.getString("name"));
		ac.setMobileNo(rs.getString("mobileno"));
		ac.setEmail(rs.getString("email"));
		ac.setBalance(rs.getDouble("balance"));
		ac.setDate(rs.getDate("date1"));
		return ac;
		}else{
		throw new AccountWalletException("mobile no does not exists");
		}
		 
		 
		}catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new AccountWalletException(e.getMessage());
		}
		 
		}

		 
	}
	



