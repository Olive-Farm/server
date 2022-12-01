package com.example.olivebookserver.service;

import com.example.olivebookserver.dto.AllSpending;
import com.example.olivebookserver.dto.UserSpending;
import com.example.olivebookserver.dto.Spending;
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
                setAllUser(allSpending.getUserID(), allSpending.userSpendingList);
            }
        }
        return allSpendingList;
    }

    public List<UserSpending> setAllUser(String userID, List<UserSpending> userSpendingList) {
        if (userSpendingList != null && userSpendingList.size() > 0) {
            for(UserSpending userSpending : userSpendingList) {
                userSpending.setYearSpendingList(spendingMapper.getByYear(userID));
            }
        }
        return userSpendingList;
    }
}
