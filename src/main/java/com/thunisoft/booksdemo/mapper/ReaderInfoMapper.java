package com.thunisoft.booksdemo.mapper;

import com.thunisoft.artery.data.annotation.DataTranslate;
import com.thunisoft.artery.data.mybatis.page.BaseMapper;
import com.thunisoft.booksdemo.bean.ReaderInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReaderInfoMapper extends BaseMapper<ReaderInfo, Integer> {
    @Select("select * from readerinfo where 1=1 and " +
            "((#{r_id} != 0 and r_id = #{r_id}) or #{r_id} = 0) and" +
            "((#{r_type} is not null and r_type = #{r_type}) or #{r_type} is null) and" +
            "((#{r_name} is not null and r_name = #{r_name}) or #{r_name} is null) and" +
            "((#{r_sex} is not null and r_sex = #{r_sex}) or #{r_sex} is null) and" +
            "((#{r_major} is not null and r_major = #{r_major}) or #{r_major} is null) and" +
//            "((#{r_tel} is not null and bk_publishData >= #{bk_publishData_start} and bk_publishData <= #{bk_publishData_end}) or #{bk_publishData_start} is null) and" +
            "((#{r_brNum} != -1 and r_tel = #{r_brNum}) or #{r_brNum} = -1) and" +
            "((#{r_tel} is not null and r_tel = #{r_tel}) or #{r_tel} is null)")
    List<ReaderInfo> sel(ReaderInfo book);

    @Select("select * from readerinfo")
    List<ReaderInfo> findAll();

    @Update("update readerinfo set r_type = #{r_type},r_name = #{r_name},r_sex = #{r_sex},r_tel = #{r_tel},r_major = #{r_major} where r_id = #{r_id}")
    int update1(ReaderInfo reader);

    @Insert("insert into readerinfo(r_id,r_type,r_name,r_sex,r_brNum,r_tel,r_major) " +
            "values (#{r_id},#{r_type},#{r_name},#{r_sex},10,#{r_tel},#{r_major})")
    int insertStu(ReaderInfo reader);

    @Insert("insert into readerinfo(r_id,r_type,r_name,r_sex,r_brNum,r_tel,r_major) " +
            "values (#{r_id},#{r_type},#{r_name},#{r_sex},20,#{r_tel},#{r_major})")
    int insertTeacher(ReaderInfo reader);

    @Delete("delete from readerinfo where r_id=#{r_id}")
    int delete1(ReaderInfo reader);
}
