package com.xbchen.springcloud.mongodb.factory;


import com.mongodb.Mongo;
import com.mongodb.MongoClientOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.UnknownHostException;

@Configuration
@ConditionalOnClass(Mongo.class)
@EnableConfigurationProperties(MongoProperties.class)
public class MongoAutoConfiguration {

    @Value("${spring.data.mongodb.poolSize}")
    private int poolSize;

    @Value("${spring.data.mongodb.blockSize}")
    private int blockSize;

    @Value("${spring.data.mongodb.minPoolSize}")
    private int minPoolSize;

    @Value("${spring.data.mongodb.maxIdleTimes}")
    private int maxIdleTimes;

    @Value("${spring.data.mongodb.maxWaitTime}")
    private int maxWaitTime;

    @Value("${spring.data.mongodb.connectTimeout}")
    private int connectTimeout;

    @Value("${spring.data.mongodb.socketTimeout}")
    private int socketTimeout;

    @Inject
    private MongoProperties properties;

    private Mongo mongo;

    @PreDestroy
    public void close() {
        if (this.mongo != null) {
            this.mongo.close();
        }
    }

    @Bean
    @ConditionalOnMissingBean
    @Singleton
    public Mongo mongo() throws UnknownHostException {
        MongoClientOptions options=MongoClientOptions.builder()
                .connectionsPerHost(poolSize)
                .minConnectionsPerHost(minPoolSize)
                .maxConnectionIdleTime(maxIdleTimes)
                .threadsAllowedToBlockForConnectionMultiplier(blockSize)
                .maxWaitTime(maxWaitTime)
                .socketTimeout(socketTimeout)
                .connectTimeout(connectTimeout)
                .build();
        this.mongo = this.properties.createMongoClient(options,null);
        return this.mongo;
    }

}
