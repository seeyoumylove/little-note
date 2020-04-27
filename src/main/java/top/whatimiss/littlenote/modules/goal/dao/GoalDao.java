package top.whatimiss.littlenote.modules.goal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import top.whatimiss.littlenote.modules.goal.entity.GoalEntity;

import java.util.List;

/**
 * @author wcj
 * @create 2020/4/27 下午5:13
 * @description goalMapper层
 */
@Component
@Mapper
public interface GoalDao extends BaseMapper<GoalEntity> {

    List<GoalEntity> getGoalList(@Param("userId") Long userId);
}