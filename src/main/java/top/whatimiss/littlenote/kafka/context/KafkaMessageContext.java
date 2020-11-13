package top.whatimiss.littlenote.kafka.context;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author wcj
 * @create 2020/10/23 上午9:27
 * @description
 */
@Data
public class KafkaMessageContext implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private Map<String, Object> messageMap;

}
