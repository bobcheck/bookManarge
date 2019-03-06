package com.thunisoft.booksdemo.bean;

import com.thunisoft.artery.data.annotation.CodeType;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="{db.readerinfo}")
public class ReaderInfo {
    @Column(name="r_id")
    private int r_id;
    @CodeType("1002")
    @Column(name="r_type")
    private String r_type;
    @Column(name="r_name")
    private String r_name;
    @CodeType("1000")
    @Column(name="r_sex")
    private String r_sex;
    @Column(name="r_brNum")
    private int r_brNum = -1;
    @Column(name="r_tel")
    private String r_tel;
    @CodeType("1003")
    @Column(name="r_major")
    private String r_major;

    public ReaderInfo() {
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getR_type() {
        return r_type;
    }

    public void setR_type(String r_type) {
        this.r_type = r_type;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }




    public int getR_brNum() {
        return r_brNum;
    }

    public void setR_brNum(int r_brNum) {
        this.r_brNum = r_brNum;
    }

    public String getR_sex() {
        return r_sex;
    }

    public void setR_sex(String r_sex) {
        this.r_sex = r_sex;
    }


    public String getR_major() {
        return r_major;
    }

    public void setR_major(String r_major) {
        this.r_major = r_major;
    }

    public String getR_tel() {
        return r_tel;
    }

    public void setR_tel(String r_tel) {
        this.r_tel = r_tel;
    }
}


