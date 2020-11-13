package top.whatimiss.littlenote.kafka.producer.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.whatimiss.littlenote.kafka.context.KafkaMessageContext;
import top.whatimiss.littlenote.kafka.producer.AbstractKafkaMessageSendClient;
import top.whatimiss.littlenote.kafka.producer.KafkaMessageProducer;

/**
 * @author wcj
 * @create 2020/10/23 上午9:35
 * @description 发送kafka消息的客户端
 */
@Component
public class KafkaMessageSendClient implements AbstractKafkaMessageSendClient {

    @Autowired
    private KafkaMessageProducer kafkaMessageProducer;

    /**
     * 异步发送方法
     * @param messageContext
     */
    @Override
    public void sendAsync(KafkaMessageContext messageContext) {
        kafkaMessageProducer.sendAsync(messageContext);
    }

    /**
     * 同步发送消息
     * @param messageContext
     */
    @Override
    public void sendSync(KafkaMessageContext messageContext) {
        kafkaMessageProducer.sendSync(messageContext);
    }
}
