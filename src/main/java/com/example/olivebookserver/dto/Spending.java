package com.example.olivebookserver.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * 각 출입금 정보 개별에 대한 클래스입니다(삭제, 개별조회, 수정, 입력에 사용). 이미지 관한 변수는 추후 구현
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
