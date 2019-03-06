package com.thunisoft.booksdemo.bean;

import com.thunisoft.artery.data.annotation.CodeType;

import java.io.Serializable;

public class code implements Serializable {

    private static final long serialVersionUID = 1L;
    private String code;
    private String codeType;
    @CodeType("2001")
    private String name;

    public code() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
