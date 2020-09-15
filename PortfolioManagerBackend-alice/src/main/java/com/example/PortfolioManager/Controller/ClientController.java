package com.example.PortfolioManager.Controller;

import com.example.PortfolioManager.Entity.ClientEntity;
import com.example.PortfolioManager.Service.ClientServiceImpl;
import com.example.PortfolioManager.VO.ClientVO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientServiceImpl clientService;
    @Autowired
    private ClientVO clientVO;

    @ResponseBody
    @RequestMapping("/clients")
    public List<ClientEntity> getAllClients(){
        return clientService.findAll();
    }

    @ResponseBody
    @RequestMapping("/client")
    public ClientVO getClient(@RequestParam( value = "id", required = true, defaultValue = "0") String clientId){
        clientVO.setClientId(clientId);
        clientVO.setClientName(clientService.getClientName(clientId));
        clientVO.setNetWorth(clientService.getNetWorth(clientId));
        return clientVO;
    }

//    @Bean
    // deal with format problem in mongo, get rid of "_class" suffix
//    public MappingMongoConverter mappingMongoConverter(MongoDatabaseFactory factory, MongoMappingContext context, BeanFactory beanFactory) {
//        DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
//        MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver, context);
//        try {
//            mappingConverter.setCustomConversions(beanFactory.getBean(CustomConversions.class));
//        } catch (NoSuchBeanDefinitionException ignore) {
//        }
//
//        mappingConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
//        return mappingConverter;
//    }

}
