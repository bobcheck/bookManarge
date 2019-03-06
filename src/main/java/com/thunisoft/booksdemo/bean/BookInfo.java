package com.thunisoft.booksdemo.bean;


import com.thunisoft.artery.data.annotation.CodeType;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name="{db.bookinfo}")
public class BookInfo {
    @Column(name="bk_id")
    private int bk_id;
    @CodeType("1001")
    @Column(name="bk_type")
    private String bk_type;
    @Column(name="bk_name")
    private String bk_name;
    @Column(name="bk_ISBN")
    private String bk_ISBN;
    @Column(name="bk_author")
    private String bk_author;
    @Column(name="bk_publishData")
    private Date bk_publishData;
    @Column(name="bk_price")
    private int bk_price;
    @Column(name="bk_rest")
    private int bk_rest;
    @Column(name="bk_img")
    private String bk_img;
//    private Date bk_publishData_start;
//    private Date bk_publishData_end;



    public BookInfo() {
    }


    public Date getBk_publishData() {
        return bk_publishData;
    }

    public void setBk_publishData(Date bk_publishData) {
        this.bk_publishData = bk_publishData;
    }

    public int getBk_id() {
        return bk_id;
    }

    public void setBk_id(int bk_id) {
        this.bk_id = bk_id;
    }

    public String getBk_type() {
        return bk_type;
    }

    public void setBk_type(String bk_type) {
        this.bk_type = bk_type;
    }

    public String getBk_name() {
        return bk_name;
    }

    public void setBk_name(String bk_name) {
        this.bk_name = bk_name;
    }

    public String getBk_ISBN() {
        return bk_ISBN;
    }

    public void setBk_ISBN(String bk_ISBN) {
        this.bk_ISBN = bk_ISBN;
    }

    public String getBk_author() {
        return bk_author;
    }

    public void setBk_author(String bk_author) {
        this.bk_author = bk_author;
    }

    public int getBk_price() {
        return bk_price;
    }

    public void setBk_price(int bk_price) {
        this.bk_price = bk_price;
    }


//    public Date getBk_publishData_start() {
//        return bk_publishData_start;
//    }
//
//    public void setBk_publishData_start(Date bk_publishData_start) {
//        this.bk_publishData_start = bk_publishData_start;
//    }
//
//    public Date getBk_publishData_end() {
//        return bk_publishData_end;
//    }
//
//    public void setBk_publishData_end(Date bk_publishData_end) {
//        this.bk_publishData_end = bk_publishData_end;
//    }

    public String getBk_img() {
        return bk_img;
    }

    public void setBk_img(String bk_img) {
        this.bk_img = bk_img;
    }

    public int getBk_rest() {
        return bk_rest;
    }

    public void setBk_rest(int bk_rest) {
        this.bk_rest = bk_rest;
    }



}
