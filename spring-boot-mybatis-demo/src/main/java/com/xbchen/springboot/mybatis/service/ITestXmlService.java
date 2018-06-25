package com.xbchen.springboot.mybatis.service;

import com.xbchen.springboot.mybatis.model.Account;

import java.util.List;

public interface ITestXmlService {

	
	public int insertAccount(Account account) throws Exception;

	public Account findAccountById(int i);
	
	public List<Account> findAccountsById(int i);
}
