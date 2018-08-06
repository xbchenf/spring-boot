package com.xbchen.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xbchen on 2018/06/25.
 */
@RestController
@RequestMapping("/test")
public class Controller {

    @ResponseBody
    @GetMapping("/hello")
    public String hello (){
        return "helloworld";
    }
}
