package com.example.PortfolioManager.DAO;

import com.example.PortfolioManager.Entity.SecurityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface SecurityDAO extends MongoRepository<SecurityEntity, Integer> {
    public SecurityEntity findBySecurityIdaAndDate(String securityId, String dateStr);
}
