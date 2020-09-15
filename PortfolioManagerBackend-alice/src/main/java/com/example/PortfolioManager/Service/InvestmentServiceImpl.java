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
        return 0.1f;
    }

    @Override
    public HashMap<String, Float> getInvestments(String clientId) {
        return null;
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
