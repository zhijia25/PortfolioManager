package com.example.PortfolioManager.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Data
public class InvestmentVO extends VO {
    private double totalAmount;
    private HashMap<String, Double> investments;
    private HashMap<String, Double> gainers;
    private HashMap<String, Double> losers;
    private HashMap<String, Double> marketMove;
    private double holdingMove;
}
