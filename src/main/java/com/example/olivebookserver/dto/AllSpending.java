package com.example.olivebookserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * 사용자별 클래스 내부에 년도별 클래스 리스트 정보, spID(id-각 출입금 별 id)는 정보를 가져오지만 데이터에 출력X
*/
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AllSpending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    private String userID;
    public List<UserSpending> userSpendingList;
}
