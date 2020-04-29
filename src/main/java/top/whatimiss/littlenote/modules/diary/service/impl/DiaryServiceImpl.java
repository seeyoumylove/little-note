package top.whatimiss.littlenote.modules.diary.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.whatimiss.littlenote.common.utils.PageUtils;
import top.whatimiss.littlenote.common.utils.Query;
import top.whatimiss.littlenote.modules.diary.dao.DiaryDao;
import top.whatimiss.littlenote.modules.diary.entity.DiaryEntity;
import top.whatimiss.littlenote.modules.diary.service.DiaryService;

import java.util.List;
import java.util.Map;

/**
 * @author wcj
 * @create 2020/4/28  下午5:54
 * @description 日记的实现类
 */
@Service
public class DiaryServiceImpl extends ServiceImpl<DiaryDao, DiaryEntity> implements DiaryService {



    /**
     * 获取日记列表
     * @param params
     * @return
     */
    @Override
    public PageUtils getList(Map params) {
        String userId = (String) params.get("userId");
        String diaryType = (String) params.get("diaryType");
        IPage<DiaryEntity> page = new Query<DiaryEntity>().getPage(params);
        List<DiaryEntity> list = this.baseMapper.getList(page,diaryType,userId);
        page.setRecords(list);
        return new PageUtils(page);
    }

    /**
     * 日记类型列表
     * @return
     */
    @Override
    public List<Map<String, Object>> diaryTypeList() {
        return this.baseMapper.diaryTypeList();
    }

}
