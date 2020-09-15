package com.example.PortfolioManager.Service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface CashService {
    //    returns the total value of client's cash accounts
    float getTotalAmount(String clientId);

    //    returns each account and its value
    HashMap<String, Float> getCashes(String clientId);

    //    returns total income of the client (dividend + interest + ...., can be mocked)
    float getTotalIncome(String clientId);

    //    returns each component and its ratio of total income
    HashMap<String, Float> getIncomeBreakdown(String clientId);

    //    returns total spend of the client (buy stock...)
    float getTotalSpend(String clientId);

    //    returns each component and its ratio of total spend
    HashMap<String, Float> getSpendBreakdown(String clientId);
}
