package com.example.olivebookserver.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.List;

/**
 * SPENDING 테이블에 대한 클래스입니다. 이미지 관한 변수는 추후 구현
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "SPENDING")

public class Spending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer SP_ID;
    private String USER_ID;
    private Timestamp SP_Time;
    private String SP_Name;
    private Integer SP_Amount;
    private String SP_Category;
    private String SP_Method;
    private String SP_Memo;
}
