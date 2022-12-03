package com.example.olivebookserver.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 사용자별, 년도별, 월별, 일별 데이터가 담고 있는 정보(일자 포함 시간, 이름 등등의 정보)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "DAY_SPENDING")
public class DaySpending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String time;
    private String name;
    private Integer amount;
    private String category;
    private String method;
    private String memo;
}
