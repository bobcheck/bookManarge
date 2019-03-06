package com.thunisoft.booksdemo.mapper;

import com.thunisoft.artery.data.annotation.DataTranslate;
import com.thunisoft.booksdemo.bean.code;
import com.thunisoft.booksdemo.bean.code;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CodeMapper {
    @DataTranslate
    @Select("select a.codeType,a.name,b.code from code1 a inner join codetype1 b on a.codeType = b.codeType")
    List<code> findAll();
}
