package com.example.PortfolioManager.DAO;

import com.example.PortfolioManager.Entity.SecurityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecurityDAO extends MongoRepository<SecurityEntity, Integer> {
    SecurityEntity findBySecurityIdAndDate(String securityId, String date);
    List<SecurityEntity> findBySecurityId(String securityName);

}
