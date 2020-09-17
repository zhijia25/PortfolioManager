package com.example.PortfolioManager.Controller;

import com.example.PortfolioManager.Service.InvestmentServiceImpl;
import com.example.PortfolioManager.VO.InvestmentVO;
import com.example.PortfolioManager.VO.SecurityVO;
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
    @Autowired
    private SecurityVO securityVO;

    @GetMapping("/investment")
    public InvestmentVO getInvestment(@RequestParam( value = "id", required = true, defaultValue = "0") String clientId,
                                      @RequestParam(value = "date", required = false, defaultValue = "2020/9/11") String date){
        investmentVO.setTotalAmount(investmentService.getTotalAmount(clientId)[0]);
        investmentVO.setInvestments(investmentService.getInvestments(clientId, date));
        investmentVO.setGainers(investmentService.getWinners(clientId));
        investmentVO.setGainers(investmentService.getLosers(clientId));
        investmentVO.setMarketMove(investmentService.getMarketMove());
        investmentVO.setHoldingMove(investmentService.getHoldingMove(clientId));
        return investmentVO;
    }

    @GetMapping("/history_value")
    public SecurityVO getHistoryValue(@RequestParam( value = "security", required = true, defaultValue = "AAPL") String securityId){
        securityVO.setSecurityId(securityId);
        securityVO.setHistoryValue(investmentService.getHistoryValue(securityId));
        return securityVO;
    }

}
