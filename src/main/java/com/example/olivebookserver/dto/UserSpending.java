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

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "USER_SPENDING")
public class UserSpending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Timestamp time;
    private String name;
    private Integer amount;
    private String category;
    private String method;
    private String memo;
}
