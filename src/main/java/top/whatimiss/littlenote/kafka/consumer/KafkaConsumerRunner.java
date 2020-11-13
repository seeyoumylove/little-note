package top.whatimiss.littlenote.kafka.consumer;

import com.ark.cloud.message.kafka.context.KafkaMessageContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * @author wcj
 * @create 2020/10/23 上午9:37
 * @description 消费线程
 */
@Slf4j
@Component("kafkaConsumerRunner")
public class KafkaConsumerRunner implements Runnable {

    private Properties props = new Properties();


    @Value("${kafka.enable}")
    private Boolean enableKafka;

    @Value("${kafka.bootstrap_server}")
    private String bootstrapServer;

    @Value("${kafka.my_topic}")
    private List<String> topic;

    @Value("${kafka.enable.auto.commit}")
    private String autoCommit;

    @Value("${kafka.auto.commit.interval.ms}")
    private String intervalMs;

    @Value("${kafka.key.deserializer}")
    private String keyDeserializer;

    @Value("${kafka.value.deserializer}")
    private String valueDeserializer;

    @Value("${kafka.group.id}")
    private String groupID;

    //是否停止线程：true-停止，false-开启
    private boolean closed = false;

    @Override
    public void run() {
        log.info("=============启动了kafka消费线程=============");
        //kafka消费者
        KafkaConsumer<String, byte[]> consumer = createKafkaConsumer();
        while (!closed) {
            try {
                ConsumerRecords<String, byte[]> record = consumer.poll(1000);
                Iterator<ConsumerRecord<String, byte[]>> iterator = record.iterator();
                while (iterator.hasNext()) {
                    log.info("============接受到消息了=============");
                    ConsumerRecord<String, byte[]> consumerRecord = iterator.next();
                    //序列化消息对象
                    KafkaMessageContext context = deserialize(consumerRecord.value());
                    if (context != null) {
                        execute(context);
                        log.info("接收到消息"+context.getMessageMap());
                    } else {
                        log.error("===kafka消息对象为空！！！===");
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    log.error("===消费线程休眠出错！", e);
                }
            } catch (Exception e) {
                log.error("===消费消息出错啦！", e);
            }
        }
    }


    /**
     * 停止消费者线程
     * @param closed
     */
    public void shutDown(boolean closed) {
        this.closed = closed;
    }

    /**
     * 初始化消费者线程
     * @return
     */
    @PostConstruct
    public KafkaConsumer<String, byte[]> createKafkaConsumer() {
        if (enableKafka) {
            props.put("bootstrap.servers", bootstrapServer);
            props.put("group.id", groupID);
            props.put("enable.auto.commit", autoCommit);
            props.put("auto.commit.interval.ms", intervalMs);
            props.put("key.deserializer", keyDeserializer);
            props.put("value.deserializer", valueDeserializer);
            KafkaConsumer<String, byte[]> consumer = new KafkaConsumer<>(props);
            consumer.subscribe(topic);
            return consumer;
        } else {
            return null;
        }

    }

    /**
     * 反序列化
     * @param ioByte
     * @return
     */
    private KafkaMessageContext deserialize(byte[] ioByte) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(ioByte);
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            KafkaMessageContext kafkaMessageContext = (KafkaMessageContext) objectInputStream.readObject();
            return kafkaMessageContext;
        } catch (IOException e) {
            e.printStackTrace();
            log.error("===把byte反序列化成对象异常===", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            log.error("===把byte反序列化成对象异常===", e);
        } finally {
            try {
                objectInputStream.close();
                byteArrayInputStream.close();
            } catch (IOException e) {
                log.error("===把byte反序列化成对象异常===", e);
            }
        }
        return null;
    }

    /**
     * 对消息进行处理
     * @param context
     */
    public void execute(KafkaMessageContext context) {
        // todo 对消息进行处理
    }

}
