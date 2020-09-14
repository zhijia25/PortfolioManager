package com.example.PortfolioManager.DAO;

import com.example.PortfolioManager.Entity.SecurityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityDAO extends MongoRepository<SecurityEntity, Integer> {
}
