package io.github.ireflux.westcitymall.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @projectName: west-city-mall
 * @package: io.github.ireflux.westcitymall.config
 * @className: rabbit dfd
 * @author: Eric
 * @description: TODO
 * @date: 2022/2/4 下午4:50
 * @version: 1.0.0
 */
@Component
@Slf4j
@RabbitListener(queues = {RabbitMQConfig.RABBITMQ_DEMO_TOPIC})
public class RabbitDemoListener {

    @RabbitHandler
    public void process(Map msgMap) {
        log.info(msgMap.toString());
        System.out.println(msgMap.toString());
    }
}
