package com.example.PortfolioManager.DAO;

import com.example.PortfolioManager.Entity.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDAO extends MongoRepository<ClientEntity, Integer> {
    ClientEntity findByClient_id(String clientId);
}
