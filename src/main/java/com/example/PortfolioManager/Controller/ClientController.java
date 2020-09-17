package com.example.PortfolioManager.Controller;

import com.example.PortfolioManager.Entity.ClientEntity;
import com.example.PortfolioManager.Service.ClientServiceImpl;
import com.example.PortfolioManager.VO.AllClientResponseVO;
import com.example.PortfolioManager.VO.ClientVO;
import com.example.PortfolioManager.VO.ResponseVO;
import com.example.PortfolioManager.VO.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientServiceImpl clientService;
    @Autowired
    private ClientVO clientVO;
    @Autowired
    private ResponseVO responseVO;
    @Autowired
    private AllClientResponseVO allClientResponseVO;

    @ResponseBody
    @RequestMapping("/clients")
    public AllClientResponseVO getAllClients(){
        setOKResponse(clientService.findAll());
        System.out.println(allClientResponseVO.toString());
        return allClientResponseVO;
    }

    @ResponseBody
    @RequestMapping("/client")
    public ResponseVO getClient(@RequestParam( value = "id", required = true, defaultValue = "0") String clientId){
        clientVO.setClientId(clientId);
        clientVO.setClientName(clientService.getClientName(clientId));
        clientVO.setNetWorth(clientService.getNetWorth(clientId));
        setOKResponse(clientVO);
        return responseVO;
    }

    public void setOKResponse(VO vo){
        responseVO.setCode("200");
        responseVO.setMessage("OK");
        responseVO.setData(clientVO);
    }

    public void setOKResponse(List<ClientEntity> clientList){
        allClientResponseVO.setCode("200");
        allClientResponseVO.setMessage("OK");
        allClientResponseVO.setData(clientList);
    }


}
