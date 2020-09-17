package com.example.PortfolioManager.Service;

import com.example.PortfolioManager.DAO.ClientDAO;
import com.example.PortfolioManager.DAO.SecurityDAO;
import com.example.PortfolioManager.Entity.ClientEntity;
import com.example.PortfolioManager.Entity.Security;
import com.example.PortfolioManager.Entity.SecurityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.security.interfaces.DSAPublicKey;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        ClientEntity clientEntity = clientDAO.findByClientId(clientId);
        HashMap<String, Integer> positionMap = clientEntity.getInvestmentPositions();
        for (Map.Entry<String, Integer> entry : positionMap.entrySet()) {
            String securityID = entry.getKey();
            Integer qty = entry.getValue();
            SecurityEntity securityEntity = securityDAO.findBySecurityIdAndDate(securityID, dateStr);
            //if can't find Security Record at a date, it's on weekends or holidays, and there won't be any updated
            //security information. So we try to get data one day earlier.
            if (securityEntity != null) {
                invValue.put(securityID, qty.doubleValue() * (double) securityEntity.getPrice());
            } else {
                return getInvestments(clientId, changeDate(dateStr));
            }

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
    public HashMap<String, Double> getWinners(String clientId) {
        ClientEntity curClient = clientDAO.findByClientId(clientId);
        HashMap<String, Integer> investmentPositions = curClient.getInvestmentPositions();
        HashMap<String, Double> changeDic = getSecurityChange();
        ArrayList<Security> valueChanges = new ArrayList<>();

        for (String key: investmentPositions.keySet()){
            valueChanges.add(new Security(key, changeDic.get(key)));
        }

        valueChanges.sort(new Comparator<Security>() {
            @Override
            public int compare(Security o1, Security o2) {
                if (o1.getChange() < o2.getChange()){
                    return 1;
                }
                if (o1.getChange() > o2.getChange()){
                    return -1;
                }
                return 0;
            }

        });
        HashMap<String, Double> res = new HashMap<>();
        for(int i=0; i<3; i++){
            String key = valueChanges.get(i).getSecurityId();
            Double value = valueChanges.get(i).getChange();
            res.put(key, value);
        }
        return res;
    }

    @Override
    public HashMap<String, Double> getLosers(String clientId) {
        ClientEntity curClient = clientDAO.findByClientId(clientId);
        HashMap<String, Integer> investmentPositions = curClient.getInvestmentPositions();
        HashMap<String, Double> changeDic = getSecurityChange();
        ArrayList<Security> valueChanges = new ArrayList<>();

        for (String key: investmentPositions.keySet()){
            valueChanges.add(new Security(key, changeDic.get(key)));
        }

        valueChanges.sort(new Comparator<Security>() {
            @Override
            public int compare(Security o1, Security o2) {
                if (o1.getChange() < o2.getChange()){
                    return -1;
                }
                if (o1.getChange() > o2.getChange()){
                    return 1;
                }
                return 0;
            }

    });
        HashMap<String, Double> res = new HashMap<>();
        for(int i=0; i<3; i++){
            String key = valueChanges.get(i).getSecurityId();
            Double value = valueChanges.get(i).getChange();
            res.put(key, value);
        }
        return res;
    }



    public HashMap<Integer, Double> getHistoryValue(String securityName) {
        List<SecurityEntity> historyValues = securityDAO.findBySecurityName(securityName);
        HashMap<Integer, Double> res = new HashMap<>();
        for(int i=0; i<14; i++){
            res.put(i+1, historyValues.get(i).getPrice());
        }
        return res;
    }

    public HashMap<String, Double> getSecurityChange(){
        HashMap<String, Double> changeDic = new HashMap<>();
        changeDic.put("AAPL", 0.032);
        changeDic.put("ADBE", 0.045);
        changeDic.put("AMZN", -0.051);
        changeDic.put("BA", 0.0421);
        changeDic.put("DHR", -0.045);
        changeDic.put("DIS", 0.021);
        changeDic.put("GOOG", -0.003);
        changeDic.put("HD", 0.027);
        changeDic.put("INTC", 0.033);
        changeDic.put("JNJ", -0.023);
        changeDic.put("JPM", -0.003);
        changeDic.put("MCD", 0.001);
        changeDic.put("MMM", -0.021);
        changeDic.put("MO", 0.0173);
        changeDic.put("MSFT", 0.0121);
        changeDic.put("NKE", 0.001);
        changeDic.put("PEP", -0.003);
        changeDic.put("SBUX", 0.027);
        changeDic.put("TXN", 0.017);
        changeDic.put("UPS", -0.009);
        return changeDic;
    }

    @Override
    public HashMap<String, Double> getMarketMove() {
        HashMap<String, Double> marketMove = new HashMap<>();
        marketMove.put("S&P 500", 0.065);
        marketMove.put("DOW", -0.072);
        marketMove.put("NASDAQ", 0.04);
        return marketMove;
    }

    @Override
    public double getHoldingMove(String clientId) {
        ClientEntity curClient = clientDAO.findByClientId(clientId);
        HashMap<String, Integer> investmentPositions = curClient.getInvestmentPositions();
        HashMap<String, Double> changeDic = getSecurityChange();
        double holdingMove = 0;

        for (String key: investmentPositions.keySet()){
            holdingMove += changeDic.get(key);
        }
        return holdingMove;
    }
}
