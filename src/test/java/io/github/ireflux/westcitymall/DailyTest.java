package io.github.ireflux.westcitymall;

import io.github.ireflux.westcitymall.config.QueueConfig;
import org.junit.jupiter.api.Test;
import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class DailyTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void rabbitmqTest() {
        System.out.println(new Date());
        rabbitTemplate.convertAndSend(QueueConfig.SHERRY_EXCHANGE_NAME, QueueConfig.SHERRY_ROUTING_KEY, "hello");
    }

    @Test
    public void mathParserTest() {
        Argument age = new Argument("age", 18);
        Argument policyYear = new Argument("policyYear", 3);
        Argument payEndYear = new Argument("payEndYear", 1000);
        Argument accumulatedPremium = new Argument("accumulatedPremium", 6250);
        Argument endCash = new Argument("endCash", 11100);
        Argument amount = new Argument("amount", 11000);
        String expression = "if(payEndYear!=1000 && policyYear<payEndYear, if(age<18, max(accumulatedPremium, endCash), if(age-1<=40, max(accumulatedPremium*1.6,endCash), if(age-1<=60, max(accumulatedPremium*1.4,endCash), max(accumulatedPremium*1.2,endCash)))), if(age<18, max(accumulatedPremium, endCash), iff(age-1<=40 && policyYear=1, max(accumulatedPremium*1.6, endCash, amount*1); age-1<=40 && policyYear>1, max(accumulatedPremium*1.6, endCash, amount*(1.04^(policyYear-1))); age-1>40 && age-1<=60 && policyYear=1, max(accumulatedPremium*1.4,endCash,amount*1), age-1>40 && age-1<=60 && policyYear>1, max(accumulatedPremium*1.4,endCash,amount*(1.04^(policyYear-1))); age-1>=60 && policyYear=1,max(accumulatedPremium*1.2,endCash,amount);age-1>=60 && policyYear>1, max(accumulatedPremium*1.2,endCash,amount*(1.04^(policyYear-1))))))";
        Expression e = new Expression(expression, age, policyYear, payEndYear, accumulatedPremium, endCash, amount);
        if (e.checkSyntax()) {
            System.out.println(e.calculate());
        }else {
            System.out.println("expression err...");
        }
    }

}
