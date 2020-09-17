package com.example.PortfolioManager.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Data
public class SecurityVO extends VO {
    private String securityName;
    private HashMap<Integer, Double> historyValue;
}
