package top.whatimiss.littlenote.kafka.service;

import com.ark.cloud.message.kafka.returnresult.ReturnResult;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author wcj
 * @create 2020/11/10 下午2:40
 * @description
 */
@Slf4j
public class ParentService {


    public ReturnResult execute(String userId, Map<String, Object> params) {
        log.info("===执行父类的处理方法=====， user=" + userId + "，params=" + params);
        return null;
    }

}
