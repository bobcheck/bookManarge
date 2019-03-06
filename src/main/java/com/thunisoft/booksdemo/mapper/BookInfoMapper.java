package com.thunisoft.booksdemo.mapper;

import com.thunisoft.artery.data.mybatis.page.BaseMapper;
import com.thunisoft.booksdemo.bean.BookInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookInfoMapper extends BaseMapper<BookInfo, Integer> {
    @Select("select * from bookinfo where 1=1 and " +
            "((#{bk_id} != 0 and bk_id = #{bk_id}) or #{bk_id} = 0) and" +
            "((#{bk_type} is not null and bk_type = #{bk_type}) or #{bk_type} is null) and" +
            "((#{bk_name} is not null and bk_name = #{bk_name}) or #{bk_name} is null) and" +
            "((#{bk_ISBN} is not null and bk_ISBN = #{bk_ISBN}) or #{bk_ISBN} is null) and" +
            "((#{bk_author} is not null and bk_author = #{bk_author}) or #{bk_author} is null) and" +
            "((#{bk_publishData_start} is not null and bk_publishData >= #{bk_publishData_start} and bk_publishData <= #{bk_publishData_end}) or #{bk_publishData_start} is null) and" +
            "((#{bk_price} != -1 and bk_price = #{bk_price}) or #{bk_price} = -1) and" +
            "((#{bk_rest} != 0 and bk_rest = #{bk_rest}) or #{bk_rest} = 0)")
    List<BookInfo> sel(BookInfo book);

    @Select("select * from bookinfo")
    List<BookInfo> findAll();

    @Update("update bookinfo set bk_type = #{bk_type},bk_name = #{bk_name},bk_ISBN = #{bk_ISBN},bk_author = #{bk_author},bk_price = #{bk_price},bk_rest = #{bk_rest} where bk_id = #{bk_id}")
    int update1(BookInfo book);

    @Insert("insert into bookinfo(bk_id, bk_name, bk_type, bk_ISBN, bk_author,bk_publishData,bk_price,bk_rest) " +
            "values(#{bk_id}, #{bk_name}, #{bk_type}, #{bk_ISBN}, #{bk_author}, #{bk_publishData}, #{bk_price}, #{bk_rest})")
    int insert1(BookInfo book);

    @Delete("delete from bookinfo where bk_id=#{bk_id}")
    int delete1(BookInfo book);


}
