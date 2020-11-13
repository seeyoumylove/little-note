package top.whatimiss.littlenote.kafka.service.impl;


import com.ark.cloud.message.kafka.service.ParentService;
import com.ark.cloud.message.kafka.service.SendMailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wcj
 * @create 2020/11/10 下午2:44
 * @description
 */
@Slf4j
@Service("sendMailService")
public class SendMailServiceImpl extends ParentService implements SendMailService {
//
//    @Autowired
//    private RedisUtil redisUtil;


    @Override
    public void sendMail(String userId, Map<String, Object> params) {
//        log.info("=====sendMail===== in params=" + params);
//        System.out.println(redisUtil.get("11"));
//        if (params == null || params.isEmpty()) {
//            return;
//        }
//        Long startTime = System.currentTimeMillis();
//        SendMeilVO vo = new SendMeilVO();
//        vo.setTo((String) params.get("receiveAccount"));
//        vo.setSubject((String) params.get("subject"));
//        vo.setText((String) params.get("text"));
//        SendMailUtil sendMailUtil = SpringContextUtil.getObject(SendMailUtil.class);
//        sendMailUtil.sendSimpleMail(vo);
//        log.info("=====sendMail===== out 消耗时间=" + (System.currentTimeMillis() - startTime) + "ms");
    }
}
