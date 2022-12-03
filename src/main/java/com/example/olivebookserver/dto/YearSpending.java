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
 * 사용자별, 년도별 데이터가 담고 있는 정보(월, 해당 월 정보 리스트)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class YearSpending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String month;
    public List<MonthSpending> monthSpendingList;
}
