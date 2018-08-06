package com.xbchen.springcloud.mongodb.factory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;

/**
 * @author xbchen
 * @date 2018-8-4 16:13:30
 * @description mongodb操作入库工厂类
 */
@Configuration
@ConditionalOnClass(Mongo.class)
public class MorphiaFactory {

    @Inject
    private Mongo mongo;

    @Inject
    MongoProperties mongoProperties;

    @Bean
    public Datastore getDatastore() {
        Morphia morphia = new Morphia();
        return morphia.createDatastore((MongoClient) mongo, mongoProperties.getDatabase());
    }
}