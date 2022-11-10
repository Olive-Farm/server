package com.example.olivebookserver.mybatis;

import java.util.List;
import java.sql.Timestamp;

import org.apache.ibatis.annotations.*;

import com.example.olivebookserver.dto.Spending;

@Mapper
public interface SpendingMapper {
    @Select("Select * From SPENDING Where SP_ID=#{spID}")
    Spending getSpending(@Param("spID") Integer spID);

    @Select("SELECT * FROM SPENDING")
    List<Spending> getSpendingList();

    @Insert("INSERT INTO SPENDING VALUES(#{spID}, #{userID}, #{spTime}, #{spName}, #{spAmount}," +
            "#{spAmount}, #{spCategory}, #{spMethod}, #{spMemo})")
    int insertSpending(@Param("spID") Integer spID, @Param("userID") String userID
            , @Param("spTime") Timestamp spTime, @Param("spName") String spName, @Param("spAmount") Integer spAmount,
                   @Param("spCategory") String spCategory,
                   @Param("spMethod") String spMethod, @Param("spMemo") String spMemo);

    @Update("UPDATE SPENDING SET USER_ID = #{userID}, SP_TIME = #{spTime}, " +
            "SP_NAME = #{spName}, SP_AMOUNT = #{spAmount}, SP_CATEGORY = #{spCategory}," +
            "SP_METHOD = #{spMethod}, SP_MEMO = #{spMemo}" +
            "Where SP_ID = #{spID}")
    int updateSpending(@Param("spID") Integer spID, @Param("userID") String userID
            , @Param("spTime") Timestamp spTime, @Param("spName") String spName, @Param("spAmount") Integer spAmount,
                   @Param("spCategory") String spCategory,
                   @Param("spMethod") String spMethod, @Param("spMemo") String spMemo);

    @Delete("DELETE from SPENDING WHERE SP_ID=#{spID}")
    int deleteSpending(@Param("spID") Integer spID);

}
