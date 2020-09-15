package com.example.PortfolioManager.Service;

import com.example.PortfolioManager.Entity.ClientEntity;
import com.example.PortfolioManager.DAO.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientDAO clientDAO;

    @Override
    public List<ClientEntity> findAll() {
        return clientDAO.findAll();
    }

    @Override
    public String getClientName(String clientId) {
        return null;
    }

    @Override
    public HashMap<String, Float> getNetWorth(String clientId) {
        return null;
    }



}
