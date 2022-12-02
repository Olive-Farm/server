package com.example.olivebookserver.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
