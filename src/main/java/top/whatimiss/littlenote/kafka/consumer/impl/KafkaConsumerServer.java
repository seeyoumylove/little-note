package top.whatimiss.littlenote.kafka.consumer.impl;


import com.ark.cloud.message.common.utils.SpringContextUtil;
import com.ark.cloud.message.kafka.consumer.AbstractKafkaConsumerServer;
import com.ark.cloud.message.kafka.consumer.KafkaConsumerRunner;
import com.ark.cloud.message.kafka.context.KafkaMessageContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wcj
 * @create 2020/10/23 上午9:33
 * @description 消费者服务器
 */
@Slf4j
@Component
public class KafkaConsumerServer implements AbstractKafkaConsumerServer {

    //消费者数量
    @Value("${kafka.consumerNum}")
    private int consumerNum;

    @Value("${kafka.enable}")
    private Boolean enableKafka;

    //消费者线程
    private List<KafkaConsumerRunner> listConsumerThread = new ArrayList<KafkaConsumerRunner>();

    /**
     * 启动消费线程
     */
    @PostConstruct
    @Override
    public void startRun() {
        if (enableKafka) {
            for (int i = 0; i < consumerNum; i++) {
                KafkaConsumerRunner runner = SpringContextUtil.getObject(KafkaConsumerRunner.class);
                listConsumerThread.add(runner);
                Thread thread = new Thread(runner);
                thread.start();
                log.info("==================启动了kafka消费线程=============");
            }
        }
    }

    /**
     * 停止消费线程
     */
    @Override
    public void stopRun() {
        for (KafkaConsumerRunner kafkaConsumerRunner : listConsumerThread) {
            kafkaConsumerRunner.shutDown(true);
        }
    }

    /**
     *  执行异步消费
     * @param context
     */
    @Override
    public void handleAsync(KafkaMessageContext context) {

    }

    /**
     *  执同异步消费
     * @param context
     * @return
     */
    @Override
    public void handleSync(KafkaMessageContext context) {

    }
}
