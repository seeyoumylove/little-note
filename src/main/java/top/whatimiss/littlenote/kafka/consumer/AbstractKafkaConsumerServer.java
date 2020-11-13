package top.whatimiss.littlenote.kafka.consumer;


import com.ark.cloud.message.kafka.context.KafkaMessageContext;

/**
 * @author wcj
 * @create 2020/10/23 上午9:17
 * @description
 */
public interface AbstractKafkaConsumerServer {

    /**
     * 开启消费线程
     */
    public void startRun();

    /**
     * 关闭消费线程
     */
    public void stopRun();

    /**
     * 执行异步消费任务
     * @param context
     */
    public void handleAsync(KafkaMessageContext context);

    /**
     * 执行同步消费任务
     * @param context
     * @return
     */
    public void handleSync(KafkaMessageContext context);
}
