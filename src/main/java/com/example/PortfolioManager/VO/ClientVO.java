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
public class ClientVO {
    private String clientId;
    private String clientName;
    private HashMap<String, Float> netWorth;
}
