package com.example.olivebookserver.mybatis;

import java.util.List;
import java.sql.Timestamp;

import com.example.olivebookserver.dto.AllSpending;
import com.example.olivebookserver.dto.UserSpending;
import org.apache.ibatis.annotations.*;

import com.example.olivebookserver.dto.Spending;

@Mapper
public interface SpendingMapper {
    //개별 출입금 내역 조회
    @Select("SELECT * FROM SPENDING WHERE SP_ID=#{spID}")
    Spending getSpending(@Param("spID") Integer spID);

    //전체 출입금 내역 조회
    @Select("SELECT * FROM SPENDING")
    List<Spending> getSpendingList();

    @Select("SELECT * FROM SPENDING")
    @Results(id="AllSpendingMap", value={
            @Result(property = "id", column = "SP_ID"),
            @Result(property = "userID", column = "USER_ID")
    })
    List<AllSpending> getAllSpendingList();

    //사용자 ID별 출입금 내역 조회 목표
    @Select("SELECT SP_NAME, SP_AMOUNT, SP_CATEGORY, SP_METHOD, SP_MEMO FROM SPENDING WHERE USER_ID = #{userID}")
    @Results(id="UserSpendingMap", value={
            @Result(property = "time", column = "SP_TIME"),
            @Result(property = "name", column = "SP_NAME"),
            @Result(property = "amount", column = "SP_AMOUNT"),
            @Result(property = "category", column = "SP_CATEGORY"),
            @Result(property = "method", column = "SP_METHOD"),
            @Result(property = "memo", column = "SP_MEMO")
    })
    List<UserSpending> getByUserID(@Param("userID") String userID);


    //출입금 내역 입력
    @Insert("INSERT INTO SPENDING VALUES(#{spID}, #{userID}, #{spTime}, #{spName}, " +
            "#{spAmount}, #{spCategory}, #{spMethod}, #{spMemo})")
    int insertSpending(@Param("spID") Integer spID, @Param("userID") String userID
            , @Param("spTime") Timestamp spTime, @Param("spName") String spName, @Param("spAmount") Integer spAmount,
                   @Param("spCategory") String spCategory,
                   @Param("spMethod") String spMethod, @Param("spMemo") String spMemo);

    //출입금 내역 수정
    @Update("UPDATE SPENDING SET USER_ID = #{userID}, SP_TIME = #{spTime}, " +
            "SP_NAME = #{spName}, SP_AMOUNT = #{spAmount}, SP_CATEGORY = #{spCategory}," +
            "SP_METHOD = #{spMethod}, SP_MEMO = #{spMemo}" +
            "Where SP_ID = #{spID}")
    int updateSpending(@Param("spID") Integer spID, @Param("userID") String userID
            , @Param("spTime") Timestamp spTime, @Param("spName") String spName, @Param("spAmount") Integer spAmount,
                   @Param("spCategory") String spCategory,
                   @Param("spMethod") String spMethod, @Param("spMemo") String spMemo);

    //출입금 내역 삭제
    @Delete("DELETE from SPENDING WHERE SP_ID=#{spID}")
    int deleteSpending(@Param("spID") Integer spID);

}
