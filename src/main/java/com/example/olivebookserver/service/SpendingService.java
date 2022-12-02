package com.example.olivebookserver.service;

import com.example.olivebookserver.dto.*;
import com.example.olivebookserver.mybatis.SpendingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpendingService {

    @Autowired
    private SpendingMapper spendingMapper;

    public List<AllSpending> getAll() {
        List<AllSpending> allSpendingList = spendingMapper.getAllSpendingList();
        if(allSpendingList != null && allSpendingList.size() > 0) {
            for(AllSpending allSpending : allSpendingList){
                allSpending.setUserSpendingList(spendingMapper.getUserSpendingList(allSpending.getUserID()));
                if (allSpending.userSpendingList != null) {
                    for(UserSpending userSpending : allSpending.userSpendingList) {
                        userSpending.setYearSpendingList(spendingMapper.getYearSpendingList(allSpending.getUserID(), userSpending.getYear()));
                        if (userSpending.yearSpendingList != null){
                            for (YearSpending yearSpending : userSpending.yearSpendingList){
                                yearSpending.setMonthSpendingList(spendingMapper.getMonthSpendingList(allSpending.getUserID(), userSpending.getYear(), yearSpending.getMonth()));
                                if (yearSpending.monthSpendingList != null){
                                    for (MonthSpending monthSpending : yearSpending.monthSpendingList){
                                        monthSpending.setDaySpendingList(spendingMapper.getByDay(allSpending.getUserID(), userSpending.getYear(), yearSpending.getMonth(), monthSpending.getDay()));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return allSpendingList;
    }

}
