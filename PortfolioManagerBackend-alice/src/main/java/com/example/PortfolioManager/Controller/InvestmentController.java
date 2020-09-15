package com.example.PortfolioManager.Controller;

import com.example.PortfolioManager.Service.InvestmentServiceImpl;
import com.example.PortfolioManager.VO.InvestmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvestmentController {
    @Autowired
    private InvestmentServiceImpl investmentService;
    @Autowired
    private InvestmentVO investmentVO;

    @GetMapping("/investment")
    public InvestmentVO getInvestment(@RequestParam( value = "id", required = true, defaultValue = "0") String clientId){
        investmentVO.setTotalAmount(investmentService.getTotalAmount(clientId));
        investmentVO.setInvestments(investmentService.getInvestments(clientId));
        investmentVO.setGainers(investmentService.getWinners(clientId));
        investmentVO.setGainers(investmentService.getLosers(clientId));
        return investmentVO;
    }

}
