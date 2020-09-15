package com.example.PortfolioManager.Service;

import com.example.PortfolioManager.DAO.CashDAO;
import com.example.PortfolioManager.DAO.ClientDAO;
import com.example.PortfolioManager.Entity.CashEntity;
import com.example.PortfolioManager.Entity.ClientEntity;
import com.example.PortfolioManager.VO.CashVO;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CashServiceImpl implements CashService {
    @Autowired
    CashDAO cashDAO;
    @Autowired
    ClientDAO clientDAO;
    @Override
    public float getTotalAmount(String clientId) {
        float total = 0f;
        ClientEntity clientEntity = clientDAO.findByClient_id(clientId);
        HashMap<String, Float> cashMap = getCashes(clientId);
        for(Map.Entry<String, Float> entry : cashMap.entrySet()){
            total += entry.getValue();
        }
        return total;
    }

    @Override
    public HashMap<String, Float> getCashes(String clientId) {
        CashEntity cash = new CashEntity();
        ClientEntity clientEntity = clientDAO.findByClient_id(clientId);
        String cashes = clientEntity.getCashes();

        List<CashEntity> cashList = cashDAO.findByAccount_number(cashes);
        Date date = cashList.get(0).getDate();
        for(int j=1;j<cashList.size();j++){
            Date tempDate = cashList.get(j).getDate();
            if(tempDate.after(date))
                date = tempDate;
        }
        CashEntity cashResult = cashDAO.findByAccount_numberAndDate(cashes, date);
        HashMap<String, Float> cashMap = new HashMap<>();
        cashMap.put(cashes,cashResult.getValue());
        return cashMap;
    }

    @Override
    public float getTotalIncome(String clientId) {
        return 0.1f;
    }

    @Override
    public HashMap<String, Float> getIncomeBreakdown(String clientId) {
        return null;
    }

    @Override
    public float getTotalSpend(String clientId) {
        return 0.1f;
    }

    @Override
    public HashMap<String, Float> getSpendBreakdown(String clientId) {
        return null;
    }

}
