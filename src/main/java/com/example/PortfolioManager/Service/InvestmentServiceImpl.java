package com.example.PortfolioManager.Service;

import com.example.PortfolioManager.DAO.SecurityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class InvestmentServiceImpl implements InvestmentService {
    @Autowired
    private SecurityDAO securityDAO;

    @Override
    public float getTotalAmount(String clientId) {
        return 11f;
    }

    @Override
    public HashMap<String, Float> getInvestments(String clientId) {
        HashMap<String, Float> res = new HashMap<>();
        res.put("apple", 12f);
        res.put("facebook", 13f);
        return res;
    }

    @Override
    public HashMap<String, String> getWinners(String clientId) {
        HashMap<String, String> res = new HashMap<>();
        res.put("facebook", "14%");
        res.put("google", "13%");
        res.put("apple", "12%");
        res.put("tesla", "11%");
        res.put("JP Morgan", "10%");
        return res;
    }

    @Override
    public HashMap<String, String> getLosers(String clientId) {
        HashMap<String, String> res = new HashMap<>();
        res.put("starbucks", "1%");
        res.put("dell", "2%");
        res.put("microsoft", "3%");
        res.put("oracle", "4%");
        res.put("nike", "4%");
        return res;
    }
}
