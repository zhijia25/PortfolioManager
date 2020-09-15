package com.example.PortfolioManager.Service;

import com.example.PortfolioManager.DAO.CashDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CashServiceImpl implements CashService {
    @Autowired
    private CashDAO cashDAO;

    @Override
    public float getTotalAmount(String clientId) {
        return 1f;
    }

    @Override
    public HashMap<String, Float> getCashes(String clientId) {
        HashMap<String, Float> res = new HashMap<>();
        res.put("citi", 2f);
        return res;
    }

    @Override
    public float getTotalIncome(String clientId) {
        return 3f;
    }

    @Override
    public HashMap<String, Float> getIncomeBreakdown(String clientId) {
        HashMap<String, Float> res = new HashMap<>();
        res.put("interest", 0.1f);
        res.put("dividend", 0.9f);
        return res;
    }

    @Override
    public float getTotalSpend(String clientId) {
        return 4f;
    }

    @Override
    public HashMap<String, Float> getSpendBreakdown(String clientId) {
        HashMap<String, Float> res = new HashMap<>();
        res.put("buy_stock", 0.1f);
        res.put("pay_loan", 0.9f);
        return res;
    }
}
