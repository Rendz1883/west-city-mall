package io.github.ireflux.westcitymall.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * rabbitmq config
 */
@Configuration
public class QueueConfig {
    public static final String SHERRY_QUEUE_NAME = "sherry_queue_name";
    public static final String SHERRY_EXCHANGE_NAME = "sherry_exchange_name";
    public static final String SHERRY_ROUTING_KEY = "sherry_routing_key";
    // 死信队列
    public static final String DLX_QUEUE_NAME = "dlx_queue_name";
    public static final String DLX_EXCHANGE_NAME = "dlx_exchange_name";
    public static final String DLX_ROUTING_KEY = "dlx_routing_key";

    @Bean
    Queue dlxQueue() {
        return new Queue(DLX_QUEUE_NAME, true, false, false);
    }

    @Bean
    DirectExchange dlxExchange() {
        return new DirectExchange(DLX_EXCHANGE_NAME, true, false);
    }

    @Bean
    Binding dlxBinding() {
        return BindingBuilder.bind(dlxQueue()).to(dlxExchange()).with(DLX_ROUTING_KEY);
    }

    @Bean
    Queue sherryQueue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-message-ttl", 1000 * 10);
        args.put("x-dead-letter-exchange", DLX_EXCHANGE_NAME);
        args.put("x-dead-letter-routing-key", DLX_ROUTING_KEY);
        return new Queue(SHERRY_QUEUE_NAME, true, false, false, args);
    }

    @Bean
    DirectExchange sherryExchange() {
        return new DirectExchange(SHERRY_EXCHANGE_NAME, true, false);
    }

    @Bean
    Binding sherryBinding() {
        return BindingBuilder.bind(sherryQueue()).to(sherryExchange()).with(SHERRY_ROUTING_KEY);
    }

}
