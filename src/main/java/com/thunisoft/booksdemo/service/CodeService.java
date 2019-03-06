package com.thunisoft.booksdemo.service;

import com.thunisoft.artery.data.annotation.DataTranslate;
import com.thunisoft.booksdemo.bean.code;
import com.thunisoft.booksdemo.mapper.CodeMapper;
import com.thunisoft.booksdemo.bean.code;
import com.thunisoft.booksdemo.mapper.CodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeService {
    @Autowired
    private CodeMapper codemapper;

    @DataTranslate
    public List<code> all(){
        return codemapper.findAll();
    }

}
