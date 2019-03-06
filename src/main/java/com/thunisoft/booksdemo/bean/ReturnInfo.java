package com.thunisoft.booksdemo.bean;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name="{db.returninfo}")
public class ReturnInfo {
    @Column(name="b_id")
    private int b_id;
    @Column(name="b_name")
    private String b_name;
    @Column(name="r_id")
    private int r_id;
    @Column(name="r_name")
    private String r_name;
    @Column(name="b_date")
    private Date b_date;
    @Column(name="r_date")
    private Date r_date;

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

    public Date getB_date() {
        return b_date;
    }

    public void setB_date(Date b_date) {
        this.b_date = b_date;
    }

    public Date getR_date() {
        return r_date;
    }

    public void setR_date(Date r_date) {
        this.r_date = r_date;
    }
}
