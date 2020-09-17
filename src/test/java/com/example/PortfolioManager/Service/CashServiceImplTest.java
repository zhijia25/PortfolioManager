package com.example.PortfolioManager.Service;

import com.example.PortfolioManager.DAO.CashDAO;
import com.example.PortfolioManager.DAO.ClientDAO;
import com.example.PortfolioManager.PortfolioManagerApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PortfolioManagerApplication.class)
class CashServiceImplTest {

    @Autowired
    CashServiceImpl cashService;

    @BeforeEach
    void setUp() {
        System.out.println("--------------------------------CashService Test Begin----------------------------");
    }

    @AfterEach
    void tearDown() {
        System.out.println("-------------------------------CashService Test End--------------------------------");
    }

    @Test
    void getTotalAmount() {
        String testClientId = "10002";
        double expectedReturn = 20000.6f;
        double actualReturn = cashService.getTotalAmount(testClientId);
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