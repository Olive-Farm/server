package com.example.olivebookserver.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.example.olivebookserver.dto.Info;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface InfoMapper {
    @Select("Select * From INFO Where id=#{id}")
    Info getInfo(@Param("id") String id);

    @Select("SELECT * FROM INFO")
    List<Info> getInfoList();

    @Insert("INSERT INTO INFO VALUES(#{id}, #{user_id}, #{list_item_date}, #{list_item_time}, #{list_item_name}," +
            "#{list_item_amount}, #{list_item_cat})")
    int insertInfo(@Param("id") String id, @Param("user_id") String user_id
            , @Param("list_item_date") String list_item_date, @Param("list_item_time") String list_item_time,
                   @Param("list_item_name") String list_item_name,
                   @Param("list_item_amount") String list_item_amount, @Param("list_item_cat") String list_item_cat);

    @Update("UPDATE Info SET user_id = #{user_id}, list_item_date = #{list_item_date}, " +
            "list_item_time = #{list_item_time}, list_item_name = #{list_item_name}, " +
            "list_item_amount = #{list_item_amount}, list_item_cat = #{list_item_cat}" +
            "Where id = #{id}")
    int updateInfo(@Param("id") String id, @Param("user_id") String user_id
            , @Param("list_item_date") String list_item_date, @Param("list_item_time") String list_item_time,
                   @Param("list_item_name") String list_item_name,
                   @Param("list_item_amount") String list_item_amount, @Param("list_item_cat") String list_item_cat);

    @Delete("DELETE from INFO WHERE id=#{id}")
    int deleteInfo(@Param("id") String id);

}
