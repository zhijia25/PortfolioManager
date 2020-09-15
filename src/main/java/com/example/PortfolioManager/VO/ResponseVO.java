package com.example.PortfolioManager.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@Data
public class ResponseVO extends VO {
    private VO data;
    private String message;
    private String code;
}
