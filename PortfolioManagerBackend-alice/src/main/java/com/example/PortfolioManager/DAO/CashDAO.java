package com.example.PortfolioManager.DAO;

import com.example.PortfolioManager.Entity.CashEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CashDAO extends MongoRepository<CashEntity, Integer> {
    @Query(sort = "{ date : -1}")
    List<CashEntity> findByAccount_number(String account_number);
    CashEntity findByAccount_numberAndDate(String accountNumber, Date date);
}
