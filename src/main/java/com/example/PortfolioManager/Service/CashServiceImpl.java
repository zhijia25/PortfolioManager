package com.example.PortfolioManager.Service;

import com.example.PortfolioManager.DAO.CashDAO;
import com.example.PortfolioManager.DAO.ClientDAO;
import com.example.PortfolioManager.DAO.FlowDAO;
import com.example.PortfolioManager.Entity.CashEntity;
import com.example.PortfolioManager.Entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.util.BsonUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CashServiceImpl implements CashService {
    @Autowired
    private CashDAO cashDAO;
    @Autowired
    ClientDAO clientDAO;
    @Autowired
    FlowDAO flowDAO;

    @Override
    public double getTotalAmount(String clientId) {
        double total = 0;
        ClientEntity clientEntity = clientDAO.findByClientId(clientId);
        HashMap<String, Double> cashMap = getCashes(clientId);
        for(Map.Entry<String, Double> entry : cashMap.entrySet()){
            total += entry.getValue();
        }
        return total;
    }

    @Override
    public HashMap<String, Double> getCashes(String clientId) {
        ClientEntity clientEntity = clientDAO.findByClientId(clientId);
        String cashes = clientEntity.getCashes();
        CashEntity cash = cashDAO.findByAccountNumber(Integer.parseInt(cashes));
        HashMap<String, Double> cashMap = new HashMap<>();
        cashMap.put(cash.getInstitutionName(), (double) cash.getValue());
        return cashMap;
    }

    @Override
    public double getTotalIncome(String clientId) {
        return flowDAO.findByClientId(clientId).getTotalIncome();
    }

    @Override
    public HashMap<String, Double> getIncomeBreakdown(String clientId) {
        HashMap<String, Integer> rawRes = flowDAO.findByClientId(clientId).getIncomeBreakdown();
        return intToDouble(rawRes);
    }

    @Override
    public double getTotalSpend(String clientId) {
        return flowDAO.findByClientId(clientId).getTotalSpend();
    }

    @Override
    public HashMap<String, Double> getSpendBreakdown(String clientId) {
        HashMap<String, Integer> rawRes = flowDAO.findByClientId(clientId).getSpendBreakdown();
        return intToDouble(rawRes);
    }

    private HashMap<String, Double> intToDouble(HashMap<String, Integer> originMap){
        HashMap<String, Double> resArr = new HashMap<>();
        for (Map.Entry<String, Integer> entry : originMap.entrySet()){
            resArr.put(entry.getKey(), (double) entry.getValue());
        }
        return resArr;
    }
}
