package top.whatimiss.littlenote.modules.diary.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import top.whatimiss.littlenote.modules.diary.entity.DiaryEntity;

import java.util.List;
import java.util.Map;

/**
 * @author wcj
 * @create 2020/4/28  下午5:55
 * @description
 */
@Component
@Mapper
public interface DiaryDao extends BaseMapper<DiaryEntity> {

    List<DiaryEntity> getList(IPage<DiaryEntity> page, @Param("diaryType") String diaryType, @Param("userId") String userId);

    List<Map<String, Object>> diaryTypeList();
}
