package com.example.PortfolioManager.VO;

import com.example.PortfolioManager.Entity.ClientEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class AllClientResponseVO extends VO{
    private String message;
    private String code;
    private List<ClientEntity> data;

}
