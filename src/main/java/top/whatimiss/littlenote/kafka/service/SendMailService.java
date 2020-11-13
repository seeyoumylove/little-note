package top.whatimiss.littlenote.kafka.service;

import java.util.Map;

/**
 * @author wcj
 * @create 2020/11/10 下午2:44
 * @description
 */
public interface SendMailService {


    void sendMail(String userId, Map<String, Object> params);
}
