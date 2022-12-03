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
 * 사용자별 데이터가 담고 있는 정보(년도, 년도별 출입금 내역 정보)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSpending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String year;
    public List<YearSpending> yearSpendingList;
}
