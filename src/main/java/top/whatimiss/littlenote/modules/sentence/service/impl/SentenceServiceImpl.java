package top.whatimiss.littlenote.modules.sentence.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.whatimiss.littlenote.common.utils.PageUtils;
import top.whatimiss.littlenote.common.utils.Query;
import top.whatimiss.littlenote.modules.diary.entity.DiaryEntity;
import top.whatimiss.littlenote.modules.sentence.dao.SentenceDao;
import top.whatimiss.littlenote.modules.sentence.entity.SentenceEntity;
import top.whatimiss.littlenote.modules.sentence.service.SentenceService;

import java.util.List;
import java.util.Map;

/**
 * @author wcj
 * @create 2020/4/29  上午9:57
 * @description 句子的实现类
 */
@Service
public class SentenceServiceImpl extends ServiceImpl<SentenceDao, SentenceEntity> implements SentenceService {


    /**
     * 获取句子列表
     * @param params
     * @return
     */
    @Override
    public PageUtils getList(Map params) {
        String sentenceType = (String) params.get("sentenceType");
        String userId = (String) params.get("userId");
        IPage<SentenceEntity> page = new Query<SentenceEntity>().getPage(params);
        List<SentenceEntity> list = this.baseMapper.getList(page,sentenceType,userId);
        page.setRecords(list);
        return new PageUtils(page);

    }

    /**
     * 获取句子类型列表
     * @return
     */
    @Override
    public List<Map<String, Object>> sentenceTypeList() {
        return this.baseMapper.sentenceTypeList();
    }
}
