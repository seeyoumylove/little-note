package top.whatimiss.littlenote.modules.goal.service;

import top.whatimiss.littlenote.modules.goal.entity.GoalEntity;

import java.util.List;

/**
 * @author wcj
 * @create 2020/4/27 下午5:10
 * @description
 */
public interface GoalService {

    List<GoalEntity> getGoalList(Long userId);
}