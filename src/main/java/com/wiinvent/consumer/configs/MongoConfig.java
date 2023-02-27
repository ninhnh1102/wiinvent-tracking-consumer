package com.wiinvent.consumer.configs;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;

@Configuration
public class MongoConfig {

  @Bean(name = "mongoTransactionManager")
  MongoTransactionManager mongoTransactionManager(MongoDatabaseFactory dbFactory) {
    TransactionOptions transactionOptions =
        TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.LOCAL)
            .writeConcern(WriteConcern.MAJORITY)
            .build();
    return new MongoTransactionManager(dbFactory, transactionOptions);
  }
}
