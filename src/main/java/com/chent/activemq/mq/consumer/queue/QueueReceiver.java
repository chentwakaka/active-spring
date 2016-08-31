package com.chent.activemq.mq.consumer.queue;

import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * Created by wangqingbin on 2016/8/31.
 */
@Component
public class QueueReceiver implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("QueueReceiver接收到消息:"+((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
