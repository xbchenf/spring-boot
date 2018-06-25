package com.xbchen.springboot.hibernate.controller;

import com.xbchen.springboot.hibernate.model.Test1Entity;
import com.xbchen.springboot.hibernate.service.ITestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xbchen on 2018/06/25.
 */
@RestController
@Controller
public class TestController {
    @Autowired
    private ITestService testService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hello")
    public String greeting() {
        return "hello";
    }

    @RequestMapping("/testGet")
    public @ResponseBody
    Test1Entity testGet(@RequestParam(name="id", required = false) int id) {
        Test1Entity test1Entity=testService.testGet(Integer.valueOf(id));
        return test1Entity;
    }

    @RequestMapping("/testSaveTransaction")
    public String testSaveTransaction() {
        try {
            testService.testSaveTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "testSaveTransaction";
    }
}
