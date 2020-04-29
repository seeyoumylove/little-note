package top.whatimiss.littlenote.modules.diary.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import top.whatimiss.littlenote.common.utils.PageUtils;
import top.whatimiss.littlenote.modules.diary.entity.DiaryEntity;

import java.util.List;
import java.util.Map;

/**
 * @author wcj
 * @create 2020/4/28  下午5:49
 * @description 日记的service层
 */
@Service
public interface DiaryService extends IService<DiaryEntity> {

    PageUtils getList(Map params);

    List<Map<String, Object>> diaryTypeList();
}
