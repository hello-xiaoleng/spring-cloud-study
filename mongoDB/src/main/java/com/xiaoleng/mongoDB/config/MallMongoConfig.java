package com.xiaoleng.mongoDB.config;

import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;



@Configuration
public class MallMongoConfig {

    @Value("${mongodb.url}")
    private String mongodbUrl;

    @Bean
    public MongoDbFactory mallMongoFactory() {
        return new SimpleMongoDbFactory(new MongoClientURI(this.mongodbUrl));
    }

    @Bean
    @Primary
    public MongoTemplate mallMongoTemplate(MongoDbFactory mallMongoFactory) {
        return new MongoTemplate(mallMongoFactory);
    }
}
