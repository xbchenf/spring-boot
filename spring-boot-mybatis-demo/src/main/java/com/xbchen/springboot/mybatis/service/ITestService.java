package com.xbchen.springboot.mybatis.service;

import com.xbchen.springboot.mybatis.model.Account;

import java.util.List;

/**
 * Created by xbchen on 2018/06/25.
 */
public interface ITestService {

    public void test();

    public boolean transfer(float money, int from, int to) throws Exception;

    public int insertAccount(Account account) throws Exception;

    public Account findAccountById(int i);

    public List<Account> findAccountsById(int i);
}
