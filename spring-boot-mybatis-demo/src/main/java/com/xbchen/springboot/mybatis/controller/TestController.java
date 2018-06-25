package com.xbchen.springboot.mybatis.controller;

import com.xbchen.springboot.mybatis.model.Account;
import com.xbchen.springboot.mybatis.service.ITestService;
import com.xbchen.springboot.mybatis.service.ITestXmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by xbchen on 2018/06/25.
 */
@RestController
@Controller
public class TestController {
    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestController.class);
    @Autowired
    private ITestService testService;

    @Autowired
    private ITestXmlService testXmlService;

    @ResponseBody
    @RequestMapping("/test")
    public List<Account> test(HttpServletRequest request, HttpServletResponse response) {
        List<Account> accountList = this.testService.findAccountsById(1);
        logger.info(accountList);
        return accountList;
    }
    @ResponseBody
    @RequestMapping("/testXml")
    public List<Account> testXml(HttpServletRequest request, HttpServletResponse response) {
        List<Account> accountList = this.testXmlService.findAccountsById(1);
        logger.info(accountList);
        return accountList;
    }
}
