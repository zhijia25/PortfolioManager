package com.example.PortfolioManager.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "Client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity {
    @Id
    private String clientId;
    @Field("client_name")
    private String clientName;
    @Field("cash")
    private String cashes;
    @Field("investment_positions")
    private List<Position> investmentPositions;

}
