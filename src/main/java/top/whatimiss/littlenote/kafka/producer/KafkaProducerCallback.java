package top.whatimiss.littlenote.kafka.producer;


import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * @author wcj
 * @create 2020/10/23 上午9:39
 * @description 步发送kafka消息的返回接口处理类
 */
public class KafkaProducerCallback  implements Callback {
    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if (e != null) {
            e.printStackTrace();
            System.err.println( "发送消息错误啦："+e.getMessage());
        }else{
            System.out.println("发送消息成功啦，命数如织，当为磐石！！");
        }
    }
}
