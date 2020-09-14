package com.example.PortfolioManager.Service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface InvestmentService {
    //    returns total amount of the client's investment account (sum of stock_value * qty)
    float getTotalAmount(String clientId);

    //    returns each stock and its current value, (stock_name: value * qty)
    HashMap<String, Float> getInvestments(String clientId);

    //    returns top5 gainers of the investment, can be achieved later
    HashMap<String, String> getWinners(String clientId);

    //    returns last5 losers of investment, can be achieved later
    HashMap<String, String> getLosers(String clientId);
}
