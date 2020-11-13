package top.whatimiss.littlenote.kafka.context;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * @author wcj
 * @create 2020/10/23 上午9:49
 * @description
 */
public class MyPartition implements Partitioner {

    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        // 分区数量
        return cluster.partitionCountForTopic(topic);
    }

    public void close() {

    }

    public void configure(Map<String, ?> map) {

    }
}
