package com.cg.accountwallet.dao;

public interface IQueryMapper {
	public String insert="insert into wallet(name,email,mobileno,balance) values(?,?,?,?)";
	public String getBal="select balance from wallet where mobileno=?";
	public String getacc="select * from wallet where mobileno=?";
	public String update="update wallet set balance=?,date1=? where mobileno=?";
}
