package com.example.PortfolioManager.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DividendDAO extends MongoRepository<DividendDAO, Integer> {
}
