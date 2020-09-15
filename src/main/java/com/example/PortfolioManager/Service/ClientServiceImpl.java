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
        Date date = new Date();

        List<CashEntity> cashes = new ArrayList<>();
        CashEntity cashEntity = new CashEntity("12345", 200f, date, "citi");
        cashes.add(cashEntity);
        List<Position> investment = new ArrayList<>();
        SecurityEntity security = new SecurityEntity("67890", "apple", date, 20f);
        Position position = new Position(security,2);
        investment.add(position);

        ClientEntity client1 = new ClientEntity("123", "andy", cashes, investment);
        ClientEntity client2 = new ClientEntity("456", "luke", cashes, investment);
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
