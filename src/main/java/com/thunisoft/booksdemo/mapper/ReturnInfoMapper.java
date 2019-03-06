package com.thunisoft.booksdemo.mapper;

import com.thunisoft.artery.data.mybatis.page.BaseMapper;
import com.thunisoft.booksdemo.bean.ReturnInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReturnInfoMapper extends BaseMapper<ReturnInfo, Integer> {
    @Select("select * from returninfo where 1=1 and "+
            "((#{b_id} != 0 and b_id = #{b_id}) or #{b_id} = 0) and" +
            "((#{b_name} is not null and b_name = #{b_name}) or #{b_name} is null) and" +
            "((#{r_id} != 0 and r_id = #{r_id}) or #{r_id} = 0) and" +
            "((#{r_name} is not null and r_name = #{r_name}) or #{r_name} is null)")
    List<ReturnInfo> sel(ReturnInfo ri);

    @Select("select * from returninfo")
    List<ReturnInfo> findAll();

    @Insert("insert into returninfo(b_id, b_name,r_id, r_name,b_date,r_date) " +
            "values(#{b_id}, #{b_name},#{r_id}, #{r_name},#{b_date}, #{r_date})")
    int insert1(ReturnInfo ri);

    @Update("update bookinfo set bk_rest= bk_rest + 1 where bk_id = #{b_id} and bk_rest >=0")
    int bookupdate(ReturnInfo ri);

    @Update("update readerinfo set r_brNum = r_brNum + 1 where r_id = #{r_id} and r_brNum >=0")
    int readerupdate(ReturnInfo ri);

    @Delete("delete from borrowinfo where b_id=#{b_id} and r_id=#{r_id}")
    int delete1(ReturnInfo ri);
}
