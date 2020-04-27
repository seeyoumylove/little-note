package top.whatimiss.littlenote.modules.goal.service.impl;

import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.whatimiss.littlenote.common.utils.CountUtils;
import top.whatimiss.littlenote.modules.goal.dao.GoalDao;
import top.whatimiss.littlenote.modules.goal.entity.GoalEntity;
import top.whatimiss.littlenote.modules.goal.service.GoalService;

import java.util.List;

/**
 * @author wcj
 * @create 2020/4/27  下午5:10
 * @description 目标模块的实现类
 */
@Service
public class GoalServiceImpl extends ServiceImpl<GoalDao,GoalEntity> implements GoalService {

    private final GoalDao goalDao;

    @Autowired
    public GoalServiceImpl(GoalDao goalDao) {
        this.goalDao = goalDao;
    }

    /**
     * 查询目标列表
     * @param userId
     * @return
     */
    @Override
    public List<GoalEntity> getGoalList(Long userId) {
        List<GoalEntity> goalList = goalDao.getGoalList(userId);
        goalList.stream().forEach(goalEntity -> {
            if (goalEntity.getCurrentValue() != null && goalEntity.getGoalValue() != null) {
                goalEntity.setProcess(CountUtils.getRateByDecimal(goalEntity.getCurrentValue(),goalEntity.getGoalValue()));
            }
        });
        return goalList;
    }

}
