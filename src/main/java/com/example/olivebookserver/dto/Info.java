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
 * member라는 값이 입력되도록 임시로 넣어놨습니다.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "INFO")

public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String USER_ID;
    private String list_Item_Date;
    private String list_Item_Time;
    private String list_Item_Name;
    private String list_Item_Amount;
    private String list_Item_Cat;
}
