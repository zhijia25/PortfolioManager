package com.example.PortfolioManager.Service;

import com.example.PortfolioManager.Entity.CashEntity;
import com.example.PortfolioManager.Entity.ClientEntity;
import com.example.PortfolioManager.DAO.ClientDAO;
import com.example.PortfolioManager.Entity.Position;
import com.example.PortfolioManager.Entity.SecurityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientDAO clientDAO;
    @Autowired
    CashServiceImpl cashService;
    @Autowired
    InvestmentServiceImpl investmentService;

    @Override
    public List<ClientEntity> findAll() {
        return clientDAO.findAll();
    }

    @Override
    public String getClientName(String clientId) {
        return clientDAO.findByClientId(clientId).getClientName();
    }

    @Override
    public HashMap<Integer, Double> getNetWorth(String clientId) {
        HashMap<Integer, Double> res = new HashMap<>();
        for (int i=0;i<14;i++){
            res.put(i+1,cashService.getTotalAmount(clientId) + investmentService.getTotalAmount(clientId)[i]);
        }
        return res;
    }

}
