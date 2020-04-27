package top.whatimiss.littlenote.modules.goal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.whatimiss.littlenote.common.entity.Result;
import top.whatimiss.littlenote.modules.goal.entity.GoalEntity;
import top.whatimiss.littlenote.modules.goal.service.GoalService;

import java.util.List;

/**
 * @author wcj
 * @create 2020/4/27  下午5:09
 * @description 目标模块的controller
 */
@RequestMapping("goal")
@RestController
public class GoalController {

    private final GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    /**
     * 查询目标列表
     * @param userId
     * @return
     */
    @GetMapping("getGoalList")
    public Result getGoalList(@RequestParam Long userId) {
        List<GoalEntity> goalEntityList = goalService.getGoalList(userId);
        return Result.success(goalEntityList);
    }
}
