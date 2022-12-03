package com.example.olivebookserver.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * 년도별 정보 클래스 내부에 있는 클래스(일자와 일자별 정보 리스트 가지고 있음)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MonthSpending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String day;
    public List<DaySpending> daySpendingList;
}
