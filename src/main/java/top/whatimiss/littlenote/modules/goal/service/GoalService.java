package top.whatimiss.littlenote.modules.goal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.whatimiss.littlenote.modules.goal.entity.GoalEntity;

import java.util.List;

/**
 * @author wcj
 * @create 2020/4/27 下午5:10
 * @description
 */
public interface GoalService extends IService<GoalEntity> {

    List<GoalEntity> getGoalList(Long userId);
}