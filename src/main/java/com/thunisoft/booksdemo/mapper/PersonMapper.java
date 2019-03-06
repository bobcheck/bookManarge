package com.thunisoft.booksdemo.mapper;

import com.thunisoft.booksdemo.bean.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PersonMapper {

    @Select("select name,pwd from user where 1=1 and " +
            "((#{name} is not null and name = #{name}) or #{name} is null) and" +
            "((#{pwd} is not null and pwd = #{pwd}) or #{pwd} is null)")

    List<Person> sel(Person per);

    @Select("select name,pwd from user")
    List<Person> findAll();

}

