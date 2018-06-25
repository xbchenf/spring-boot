package com.xbchen.springboot.mybatis.mapper;

import com.xbchen.springboot.mybatis.model.Account;

import java.util.List;

/**
 * Created by xbchen on 2018/06/25.
 */
public interface TestXmlMapper {

    public int addMoney(int userId, float money);

    public int minusMoney(int userId, float money);

    //@CacheEvict(value = {"indexCache"},allEntries = true,beforeInvocation = true)
    public int insertAccount(Account account);

    //@Cacheable(value = "indexCache",key = "'xmlgetAccountById'+#id")
    public Account getAccountById(int id);

    //@Cacheable(value = "indexCache",key = "'xmlfindAccountsById'+#id")
    public List<Account> findAccountsById(int id);
}
