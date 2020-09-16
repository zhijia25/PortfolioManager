package com.example.PortfolioManager.DAO;

import com.example.PortfolioManager.Entity.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDAO extends MongoRepository<ClientEntity, String> {
    public ClientEntity findByClientId(String clientId);
}
