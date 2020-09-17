package com.example.PortfolioManager.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Flow")
public class FlowEntity {

    @Field("client_id")
    private String clientId;
    @Field("total_income")
    private int totalIncome;
    @Field("total_spend")
    private int totalSpend;
    @Field("income_breakdown")
    private HashMap<String, Integer> incomeBreakdown;
    @Field("spend_breakdown")
    private HashMap<String, Integer> spendBreakdown;
}
