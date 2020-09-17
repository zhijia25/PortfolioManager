package com.example.PortfolioManager.Service;

import com.example.PortfolioManager.PortfolioManagerApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PortfolioManagerApplication.class)
class ClientServiceImplTest {
    @Autowired
    ClientServiceImpl clientService;
    @Test
    void findAll() {
    }

    @Test
    void getClientName() {
        String testClientId = "10002";
        String actualReturn = clientService.getClientName(testClientId);
        String expectedReturn = "William Lu";
        assertEquals(expectedReturn, actualReturn);
    }

    @Test
    void getNetWorth() {
    }
}