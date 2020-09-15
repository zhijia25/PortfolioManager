package com.example.PortfolioManager.Controller;

import com.example.PortfolioManager.Service.CashServiceImpl;
import com.example.PortfolioManager.VO.CashVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashController {
    @Autowired
    private CashServiceImpl cashService;
    @Autowired
    private CashVO cashVO;

    @GetMapping("/cash")
    public CashVO getCash(@RequestParam( value = "id", required = true, defaultValue = "0") String clientId){
        cashVO.setTotalAmount(cashService.getTotalAmount(clientId));
        cashVO.setCashes(cashService.getCashes(clientId));
        cashVO.setTotalIncome(cashService.getTotalIncome(clientId));
        cashVO.setIncomeBreakdown(cashService.getIncomeBreakdown(clientId));
        cashVO.setTotalSpend(cashService.getTotalSpend(clientId));
        cashVO.setSpendBreakdown(cashService.getSpendBreakdown(clientId));
        return cashVO;
    }

}
