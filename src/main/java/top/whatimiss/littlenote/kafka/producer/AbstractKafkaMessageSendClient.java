package top.whatimiss.littlenote.kafka.producer;


import top.whatimiss.littlenote.kafka.context.KafkaMessageContext;

/**
 * @author wcj
 * @create 2020/10/23 上午9:35
 * @description 发送kafka消息的接口
 */
public interface AbstractKafkaMessageSendClient {

    /**
     * 发送异步消息
     * @param messageContext
     */
    public void sendAsync(KafkaMessageContext messageContext);

    /**
     * 同步发送消息
     * @param messageContext
     * @return
     */
    public void sendSync(KafkaMessageContext messageContext);
}
