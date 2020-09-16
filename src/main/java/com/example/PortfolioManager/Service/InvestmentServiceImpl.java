package com.example.PortfolioManager.Service;

import com.example.PortfolioManager.DAO.ClientDAO;
import com.example.PortfolioManager.DAO.SecurityDAO;
import com.example.PortfolioManager.Entity.ClientEntity;
import com.example.PortfolioManager.Entity.SecurityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InvestmentServiceImpl implements InvestmentService {
    @Autowired
    private SecurityDAO securityDAO;

    @Autowired
    private ClientDAO clientDAO;

    @Override
    public double[] getTotalAmount(String clientId) {
        double[] totalAmount30Days = new double[30];
        int day = 11;
        String prefix1 = "2020/8/";
        String prefix2 = "2020/9/";
        for (int i = 0; i < 30; i++) {
            String s;
            if (day - i <= 0) {
                day = day + 31 - i;
                s = prefix1 + day;
            } else {
                day = day - i;
                s = prefix2 + day;
            }
            HashMap<String, Double> inv = getInvestments(clientId, s);
            for (Map.Entry<String, Double> entry : inv.entrySet()) {
                totalAmount30Days[i] += entry.getValue();
            }
        }
        return totalAmount30Days;
    }


    @Override
    public HashMap<String, Double> getInvestments(String clientId, String date) {
        HashMap<String, Double> invValue = new HashMap<>();
        ClientEntity clientEntity = clientDAO.findByClientId(clientId);
        HashMap<String, Integer> positionMap = clientEntity.getInvestmentPositions();
        for (Map.Entry<String, Integer> entry : positionMap.entrySet()) {
            String securityID = entry.getKey();
            Integer qty = entry.getValue();
            SecurityEntity securityEntity = securityDAO.findBySecurityIdaAndDate(securityID, date);
            //if can't find Security Record at a date, it's weekend or vacation, and there is not any updated security information.
            if (securityEntity != null) {
                invValue.put(securityID, qty.floatValue() * (double)securityEntity.getPrice());
            } else {
               getInvestments(clientId,changeDate(date));
            }
        }
        return invValue;
    }

    private String changeDate(String originStr) {
        String[] strArray = originStr.split("/");
        int year = Integer.valueOf(strArray[0]);
        int month = Integer.valueOf(strArray[1]);
        int day = Integer.valueOf(strArray[2]);
        if (day - 1 > 0) {
            day--;
        } else if (month - 1 > 0) {
            month--;
            if (month == 2) {
                day = 28;
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                day = 30;
            } else {
                day = 31;
            }
        } else {
            year--;
            month = 12;
            day = 31;
        }
        return ""+year+"/"+month+"/"+day;
    }

    @Override
    public HashMap<String, String> getWinners(String clientId) {
        return null;
    }

    @Override
    public HashMap<String, String> getLosers(String clientId) {
        return null;
    }
}
