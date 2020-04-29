package top.whatimiss.littlenote.modules.sentence.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import top.whatimiss.littlenote.modules.sentence.entity.SentenceEntity;

import java.util.List;
import java.util.Map;

/**
 * @author wcj
 * @create 2020/4/29  上午9:58
 * @description 句子的dao层
 */
@Component
@Mapper
public interface SentenceDao extends BaseMapper<SentenceEntity> {


    List<SentenceEntity> getList(IPage<SentenceEntity> page,
                                 @Param("sentenceType") String sentenceType,
                                 @Param("userId") String userId);

    List<Map<String, Object>> sentenceTypeList();
}
