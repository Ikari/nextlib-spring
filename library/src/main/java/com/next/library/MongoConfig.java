/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.next.library;

import com.mongodb.MongoClient;
import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author roger
 */
@Configuration
public class MongoConfig {
    
    private static final String MONGO_DB_URL = "localhost";
    private static final String MONGO_DB_NAME = "embedded_db";
    
    @Bean
    public MongoTemplate mongoTemplate() throws IOException {

        EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
        mongo.setBindIp(MONGO_DB_URL);
        MongoClient mongoClient = mongo.getObject();
        return new MongoTemplate(mongoClient, MONGO_DB_NAME);
        
    }
}
