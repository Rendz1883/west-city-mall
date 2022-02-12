package io.github.ireflux.westcitymall.mq;

import io.github.ireflux.westcitymall.config.QueueConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DlxConsumer {

    private static final Logger log = LoggerFactory.getLogger(DlxConsumer.class);

    @RabbitListener(queues = QueueConfig.DLX_QUEUE_NAME)
    public void handle(String msg) {
        log.info(msg);
    }
}
