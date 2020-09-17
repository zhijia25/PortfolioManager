package com.example.PortfolioManager.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Data
public class CashVO extends VO {
     private double totalAmount;
     private HashMap<String, Double> cashes;
     private double totalIncome;
     private HashMap<String, Double> incomeBreakdown;
     private double totalSpend;
     private HashMap<String, Double> spendBreakdown;

}
