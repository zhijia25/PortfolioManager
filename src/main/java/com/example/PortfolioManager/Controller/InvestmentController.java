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
    private InvestmentServiceImpl investmentServiceImpl;
    @Autowired
    private InvestmentVO investmentVO;

    @GetMapping("/investment")
    public InvestmentVO getInvestment(@RequestParam(value = "id", required = true, defaultValue = "0") String clientId,
                                      @RequestParam(value = "date", required = false, defaultValue = "2020/9/11") String date) {
        investmentVO.setTotalAmount(investmentServiceImpl.getTotalAmount(clientId));
        investmentVO.setInvestments(investmentServiceImpl.getInvestments(clientId, date));
        investmentVO.setGainers(investmentServiceImpl.getWinners(clientId));
        investmentVO.setGainers(investmentServiceImpl.getLosers(clientId));
        return investmentVO;
    }

}
