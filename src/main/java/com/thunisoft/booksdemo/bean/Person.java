package com.thunisoft.booksdemo.bean;


public class Person {
    private String name = null;
    private String pwd = null;

    public Person() {
        super();
    }
    public Person(String name,String pwd) {
        super();
        this.name=name;
        this.pwd=pwd;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public void print(){
        System.out.println("sadasdad");
    }
}


