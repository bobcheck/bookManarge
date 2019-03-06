package com.thunisoft.booksdemo.bean;


import com.thunisoft.artery.data.annotation.CodeType;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name="{db.borrowinfo}")
public class BorrowInfo {
    @Column(name="b_id")
    private int b_id;
    @Column(name="b_name")
    private String b_name;
    @Column(name="b_rest")
    private String b_rest;
    @Column(name="r_id")
    private int r_id;
    @Column(name="r_name")
    private String r_name;
    @CodeType("1000")
    @Column(name="r_sex")
    private String r_sex;
    @CodeType("1002")
    @Column(name="r_type")
    private String r_type;
    @Column(name="r_rest")
    private int r_rest;
    @CodeType("1003")
    @Column(name="r_major")
    private String r_major;
    @Column(name="date")
    private Date date;


    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public String getB_rest() {
        return b_rest;
    }

    public void setB_rest(String b_rest) {
        this.b_rest = b_rest;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getR_sex() {
        return r_sex;
    }

    public void setR_sex(String r_sex) {
        this.r_sex = r_sex;
    }

    public String getR_type() {
        return r_type;
    }

    public void setR_type(String r_type) {
        this.r_type = r_type;
    }

    public int getR_rest() {
        return r_rest;
    }

    public void setR_rest(int r_rest) {
        this.r_rest = r_rest;
    }

    public String getR_major() {
        return r_major;
    }

    public void setR_major(String r_major) {
        this.r_major = r_major;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
