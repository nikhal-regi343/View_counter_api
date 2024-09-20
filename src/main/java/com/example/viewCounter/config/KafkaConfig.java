package com.example.viewCounter.config;

import ch.qos.logback.classic.spi.ConfiguratorRank;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.example.viewCounter.constants.KafkaConstants.YOUTUBE_SUBSCRIPTION;

@Configuration
public class KafkaConfig {


    @Bean
    public NewTopic topic(){
        return TopicBuilder.name(YOUTUBE_SUBSCRIPTION).build();
    }
}
