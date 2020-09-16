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
public class CashVO {
     private float totalAmount;
     private HashMap<String, Float> cashes;
     private float totalIncome;
     private HashMap<String, Float> incomeBreakdown;
     private float totalSpend;
     private HashMap<String, Float> spendBreakdown;
}
