package com.example.PortfolioManager.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "Cash")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CashEntity {
    @Field("account_number")
    private String accountNumber;
    @Field("value")
    private double value;
    @Field("date")
    private Date date;
    @Field("institution_name")
    private String institutionName;

}
