package top.whatimiss.littlenote.modules.sentence.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.whatimiss.littlenote.common.utils.PageUtils;
import top.whatimiss.littlenote.modules.sentence.entity.SentenceEntity;

import java.util.List;
import java.util.Map;

/**
 * @author wcj
 * @create 2020/4/29  上午9:56
 * @description
 */
public interface SentenceService extends IService<SentenceEntity> {

    PageUtils getList(Map params);

    List<Map<String, Object>> sentenceTypeList();
}
