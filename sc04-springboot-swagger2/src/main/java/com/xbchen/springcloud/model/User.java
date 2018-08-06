package com.xbchen.springcloud.model;

import java.io.Serializable;

/**
 * @author xbchen
 * @date 2018-8-3 10:36:00
 * @description
 */
public class User implements Serializable{

    private int id;
    private String name;
    private String password;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
