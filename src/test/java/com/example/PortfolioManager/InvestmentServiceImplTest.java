package com.example.PortfolioManager;

import com.example.PortfolioManager.Service.InvestmentServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvestmentServiceImplTest {
    InvestmentServiceImpl investmentService;

    @BeforeEach
    void start() {
        System.out.println("----------------test start----------------------");
        investmentService = new InvestmentServiceImpl();
    }

    @AfterEach
    void end() {
        System.out.println("-----------------test end-----------------------");
    }

    @Test
    void getTotalAmount() {
        String clientId = "10001";
        String date = "2020/9/11";
        float[] actualReturn =investmentService.getTotalAmount(clientId);
        assertEquals(actualReturn,actualReturn);
    }
}
