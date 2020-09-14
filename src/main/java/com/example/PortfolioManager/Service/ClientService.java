package com.example.PortfolioManager.Service;

import com.example.PortfolioManager.Entity.ClientEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface ClientService {
    //    returns all existing clients
    List<ClientEntity> findAll();

    //    returns name of the client
    String getClientName(String clientId);

    //    returns net worth = cash + investment of the client
    HashMap<String, Float> getNetWorth(String clientId);
}
