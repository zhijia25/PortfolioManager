package com.example.PortfolioManager.DAO;

import com.example.PortfolioManager.Entity.CashEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashDAO extends MongoRepository<CashEntity, Integer> {
}
