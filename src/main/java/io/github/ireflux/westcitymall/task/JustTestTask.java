package io.github.ireflux.westcitymall.task;

import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class JustTestTask {

    @XxlJob(value = "printLaoRenBuFuShu")
    public void testJobHandler() throws Exception {
        log.info("当前时间为: {}, 找信仰去找掉毛", LocalDateTime.now());
    }

}
