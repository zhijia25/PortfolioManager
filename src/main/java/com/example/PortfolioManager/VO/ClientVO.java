package com.example.PortfolioManager.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Data
public class ClientVO extends VO{
    private String clientId;
    private String clientName;
    private HashMap<Integer, Double> netWorth;
}
