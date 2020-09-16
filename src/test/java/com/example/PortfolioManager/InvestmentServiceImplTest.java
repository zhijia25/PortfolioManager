package com.example.PortfolioManager;

import com.example.PortfolioManager.Service.InvestmentServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DecimalFormat;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PortfolioManagerApplication.class)
public class InvestmentServiceImplTest {
    @Autowired
    InvestmentServiceImpl investmentService;

    @BeforeEach
    void start() {
        System.out.println("----------------test start----------------------");
    }

    @AfterEach
    void end() {
        System.out.println("-----------------test end-----------------------");
    }

    @Test
    void getTotalAmount() {
        String clientId = "10005";
        String date = "2020/9/11";
        double[] expectedReturn = {115.010002, 114.907501, 114.907501, 114.907501, 114.607498, 115.5625, 115.707497, 118.275002, 124.370003, 124.370003, 124.3700003, 125.857498, 124.824997, 126.522499, 125.010002, 124.807503, 124.807503, 124.807503, 129.039993, 134.179993, 131.399994, 120.879997, 120.959999, 120.959999, 120.959999, 120.959999, 112.82, 117.32, 113.489998, 110.599998};
        double[] actualReturn = investmentService.getTotalAmount(clientId);
        System.out.println("--------------------------test getTotalAmount()----------------------");
        DecimalFormat decimalFormat = new DecimalFormat("#.0000");
        for (int i = 0; i < expectedReturn.length; i++) {
            if (!decimalFormat.format(expectedReturn[29 - i]).equals(decimalFormat.format(actualReturn[i]))) {
                System.out.println("Test Failed");
            }
            System.out.println(expectedReturn[29 - i] + "/" + actualReturn[i]);
        }
        System.out.println("Test Succeed");
    }

    @Test
    void getInvestments() {
        System.out.println("--------------------------test getInvestments()----------------------");
        String clientId = "10005";
        String date = "2020/9/10";
        HashMap<String, Double> expectedReturn = new HashMap<>();
        expectedReturn.put("AAPL", 113.489998);
        HashMap<String, Double> actualReturn = investmentService.getInvestments(clientId, date);
        if (actualReturn.containsKey("AAPL")) {
            if (actualReturn.get("AAPL") == 113.48998) {
                System.out.println("getInvestments() works");
            } else {
                System.out.println(actualReturn.get("AAPL") + "  " + expectedReturn.get("AAPL"));
            }
        }else{
            System.out.println("No correct actualReturn");
        }
    }
}
