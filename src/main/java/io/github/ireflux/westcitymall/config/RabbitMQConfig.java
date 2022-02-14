package io.github.ireflux.westcitymall.config;

/**
 * @projectName: west-city-mall
 * @package: io.github.ireflux.westcitymall.config
 * @className:
 * @author: Eric
 * @description: TODO
 * @date: 2022/2/2 下午9:45
 * @version: 1.0.0
 */
public class RabbitMQConfig {

    /*
     * RabbitMQ的队列主题名称
     */
    public static final String RABBITMQ_DEMO_TOPIC = "rabbitmqDemoTopic";

    /*Rabbitmq的DIRECT交换机名称*/
    public static final String RABBITMQ_DEMO_DIRECT_EXCHANGE = "rabbitmqDemoDirectExchange";

    /* RabbitMQ的DIRECT交换机和队列绑定的匹配建DirectRouting*/
    public static final String RABBITMQ_DEMO_DIRECT_ROUTING = "rabbitmqDemoDirectRouting";

}
