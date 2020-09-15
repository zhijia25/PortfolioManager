package com.example.PortfolioManager.Service;

import com.example.PortfolioManager.Entity.ClientEntity;
import com.example.PortfolioManager.Entity.Position;
import com.example.PortfolioManager.Entity.SecurityEntity;
import org.junit.jupiter.api.Test;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceImplTest {
    ClientServiceImpl clientService;
    @Test
    void findAll() {
        List<ClientEntity> expectReturn = new LinkedList<>();
        List<ClientEntity> actualReturn = new LinkedList<>();
        String str = "2019/9/11";
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date date = null;
        try{
            date = format.parse(str);
        }catch(ParseException e){
            e.printStackTrace();
        }

        SecurityEntity securityEntity = new SecurityEntity("APPL","Apple Inc.",date,55.224567f);
        Position position = new Position(securityEntity,50);
        List<Position> positions = new LinkedList<>();
        positions.add(position);
        ClientEntity clientExpect = new ClientEntity("10005","Alice Li", "200001",positions);
        expectReturn.add(clientExpect);
        actualReturn = clientService.findAll();
        assertSame(expectReturn,actualReturn);
    }

    @Test
    void getClientName() {
    }

    @Test
    void getNetWorth() {
    }
}