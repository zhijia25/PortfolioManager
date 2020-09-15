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
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientDAO clientDAO;

    @Override
    public List<ClientEntity> findAll() {
        ArrayList<ClientEntity> res = new ArrayList<>();

        HashMap<String, Integer> investment1 = new HashMap<>();
        investment1.put("apple", 20);
        investment1.put("google", 30);

        HashMap<String, Integer> investment2 = new HashMap<>();
        investment2.put("facebook", 40);
        investment2.put("nike", 10);

        ClientEntity client1 = new ClientEntity("123", "andy", "citi", investment1);
        ClientEntity client2 = new ClientEntity("456", "luke", "Barclays", investment2);
        res.add(client1);
        res.add(client2);
        return res;
    }

    @Override
    public String getClientName(String clientId) {
        return "andy";
    }

    @Override
    public HashMap<String, Float> getNetWorth(String clientId) {
        HashMap<String, Float> res = new HashMap<>();
        res.put("andy", 2222f);
        return res;
    }

}
