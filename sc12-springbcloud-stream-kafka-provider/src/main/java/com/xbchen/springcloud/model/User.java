package com.xbchen.springcloud.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import java.io.Serializable;

/**
 * @author xbchen
 * @date 2018-8-3 10:36:00
 * @description
 */
@Entity(value = "user", noClassnameStored = true)//mongodb注解
@EnableMongoAuditing//mongodb注解
public class User implements Serializable{
    @Id//mongodb注解
    private int id;
    private String name;
    private String password;
    private int age;

    public User(){
    }
    public User(int id,String name,String password,int age){
        this.id=id;
        this.name=name;
        this.password=password;
        this.age=age;
    }
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

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + ", age=" + age + "]";
    }
}
