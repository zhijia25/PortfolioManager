package com.example.PortfolioManager.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentVO {
    private double[] totalAmount;
    private HashMap<String, Double> investments;
    private HashMap<String, String> gainers;
    private HashMap<String, String> losers;
}
