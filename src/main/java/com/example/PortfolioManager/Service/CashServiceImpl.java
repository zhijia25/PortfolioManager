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
        return 0.1f;
    }

    @Override
    public HashMap<String, Float> getCashes(String clientId) {
        return null;
    }

    @Override
    public float getTotalIncome(String clientId) {
        return 0.1f;
    }

    @Override
    public HashMap<String, Float> getIncomeBreakdown(String clientId) {
        return null;
    }

    @Override
    public float getTotalSpend(String clientId) {
        return 0.1f;
    }

    @Override
    public HashMap<String, Float> getSpendBreakdown(String clientId) {
        return null;
    }
}
