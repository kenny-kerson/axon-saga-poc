package com.kenny.axonsagapoc.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.common.jpa.EntityManagerProvider;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.modelling.saga.repository.SagaStore;
import org.axonframework.modelling.saga.repository.jpa.JpaSagaStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class AxonConfig {

    private final EntityManagerProvider entityManagerProvider;
    private final TransactionManager transactionManager;

    @Bean
    public SagaStore<Object> sagaStore() {
        return JpaSagaStore.builder()
                .entityManagerProvider(entityManagerProvider)
//                .transactionManager(transactionManager)
                .build();
    }
}
