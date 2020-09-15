package com.example.PortfolioManager.Service;

import com.example.PortfolioManager.DAO.CashDAO;
import com.example.PortfolioManager.DAO.ClientDAO;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashServiceImplTest {

//    String clientId = "10001";
    CashServiceImpl cashService;
    @BeforeEach
    void setUp() {
        System.out.println("--------------------------------CashService Test Begin----------------------------");
        cashService = new CashServiceImpl();
    }

    @AfterEach
    void tearDown() {
        System.out.println("-------------------------------CashService Test End--------------------------------");
    }

    @Test
    void getTotalAmount() {
        String clientId = "10001";
        float expectedReturn = 20000.6f;
        float actualReturn = cashService.getTotalAmount(clientId);
        assertEquals(expectedReturn,actualReturn);
    }

    @Test
    void getCashes() {

    }

    @Test
    void getTotalIncome() {
    }

    @Test
    void getIncomeBreakdown() {
    }

    @Test
    void getTotalSpend() {
    }

    @Test
    void getSpendBreakdown() {
    }

}