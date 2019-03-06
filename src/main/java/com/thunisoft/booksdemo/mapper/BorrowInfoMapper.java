package com.thunisoft.booksdemo.mapper;

import com.thunisoft.artery.data.mybatis.page.BaseMapper;
import com.thunisoft.booksdemo.bean.BorrowInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BorrowInfoMapper extends BaseMapper<BorrowInfo, Integer> {
    @Select("select * from borrowinfo where 1=1 and "+
            "((#{b_id} != 0 and b_id = #{b_id}) or #{b_id} = 0) and" +
            "((#{b_name} is not null and b_name = #{b_name}) or #{b_name} is null) and" +
            "((#{r_id} != 0 and r_id = #{r_id}) or #{r_id} = 0) and" +
            "((#{r_name} is not null and r_name = #{r_name}) or #{r_name} is null) and" +
            "((#{r_sex} is not null and r_sex = #{r_sex}) or #{r_sex} is null) and" +
            "((#{r_type} is not null and r_type = #{r_type}) or #{r_type} is null) and" +
            "((#{date} is not null and date >= #{bk_publishData_start} and date <= #{bk_publishData_end}) or #{date} is null) and" +
            "((#{r_major} is not null and r_major = #{r_major}) or #{r_major} is null)")
    List<BorrowInfo> sel(BorrowInfo bi);

    @Select("select * from borrowinfo")
    List<BorrowInfo> findAll();

    @Insert("insert into borrowinfo(b_id, b_name, b_rest, r_id, r_name,r_sex,r_type,r_rest,r_major,date) " +
            "values(#{b_id}, #{b_name}, #{b_rest}, #{r_id}, #{r_name}, #{r_sex}, #{r_type}, #{r_rest}, #{r_major}, #{date})")
    int insert1(BorrowInfo br);

    @Update("update bookinfo set bk_rest= bk_rest -1 where bk_id = #{b_id} and bk_rest > 0")
    int bookupdate(BorrowInfo br);

    @Update("update readerinfo set r_brNum = r_brNum -1 where r_id = #{r_id} and r_brNum >0")
    int readerupdate(BorrowInfo br);

    @Delete("delete from borrowinfo where b_id=#{b_id} and r_id=#{r_id}")
    int delete1(BorrowInfo br);

}
