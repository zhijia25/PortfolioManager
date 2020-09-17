package com.example.PortfolioManager.Service;

import com.example.PortfolioManager.DAO.ClientDAO;
import com.example.PortfolioManager.DAO.SecurityDAO;
import com.example.PortfolioManager.Entity.ClientEntity;
import com.example.PortfolioManager.Entity.SecurityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InvestmentServiceImpl implements InvestmentService {
    @Autowired
    private SecurityDAO securityDAO;

    @Autowired
    private ClientDAO clientDAO;

    @Override
    public double[] getTotalAmount(String clientId) {
        DecimalFormat decimalFormat = new DecimalFormat("#.0000");
        double[] totalAmount30Days = new double[30];
        int day = 12;
        String prefix1 = "2020/8/";
        String prefix2 = "2020/9/";
        String prefix = prefix2;
        String date;
        for (int i = 0; i < 30; i++) {
            if (day <= 0) {
                day = day + 31 - 1;
                prefix = prefix1;
            } else {
                day--;
            }
            date = prefix + day;
            HashMap<String, Double> inv = getInvestments(clientId, date);
            for (Map.Entry<String, Double> entry : inv.entrySet()) {
                totalAmount30Days[i] += entry.getValue();
            }
            decimalFormat.format(totalAmount30Days[i]);
        }
        return totalAmount30Days;
    }


    @Override
    public HashMap<String, Double> getInvestments(String clientId, String dateStr) {
        DecimalFormat decimalFormat = new DecimalFormat("#.0000");
        HashMap<String, Double> invValue = new HashMap<>();
        List<ClientEntity> clientEntity;

        if (clientDAO != null) {
            clientEntity = clientDAO.findByClientId(clientId);
            HashMap<String, Integer> positionMap = clientEntity.get(0).getInvestmentPositions();
            for (Map.Entry<String, Integer> entry : positionMap.entrySet()) {
                String securityID = entry.getKey();
                Integer qty = entry.getValue();
                SecurityEntity securityEntity = securityDAO.findBySecurityIdAndDate(securityID, dateStr);
                //if can't find Security Record at a date, it's on weekends or holidays, and there won't be any updated
                //security information. So we try to get data one day earlier.
                if (securityEntity != null) {
                    invValue.put(securityID, qty.doubleValue() * (double) securityEntity.getPrice());
                } else {
                    System.out.println("security is null");
                    return getInvestments(clientId, changeDate(dateStr));
                }

            }
        } else {
            System.out.println("clientDAO is null" + "/" + clientId + "/" + dateStr);
        }
        return invValue;
    }

    private Date strToDate(String dateStr) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @param originStr a String instance that represents original date
     * @return a String instance that represents a date which is one-day earlier that original date
     */
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
        return year + "/" + month + "/" + day;
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
