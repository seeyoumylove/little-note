package top.whatimiss.littlenote.modules.goal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
     *
     * @param userId
     * @return
     */
    @GetMapping("getGoalList")
    public Result getGoalList(@RequestParam Long userId) {
        List<GoalEntity> goalEntityList = goalService.getGoalList(userId);
        return Result.success(goalEntityList);
    }


    /**
     * 添加一个目标
     *
     * @param goalEntity
     * @return
     */
    @PostMapping("add")
    public Result add(@RequestBody GoalEntity goalEntity) {
        goalService.save(goalEntity);
        return Result.success();
    }

    /**
     * 更新目标
     *
     * @param goalEntity
     * @return
     */
    @PostMapping("update")
    public Result update(@RequestBody GoalEntity goalEntity) {
        goalService.updateById(goalEntity);
        return Result.success();
    }

    /**
     * 查询目标
     *
     * @param id
     * @return
     */
    @GetMapping("getGoal")
    public Result getGoal(@RequestParam String id) {
        GoalEntity goalEntity = goalService.getById(id);
        return Result.success(goalEntity);
    }

    /**
     * 删除一个目标
     * @param id
     * @return
     */
    @GetMapping("deleteGoal")
    public Result deleteGoal(@RequestParam String id) {
        goalService.removeById(id);
        return Result.success();
    }
}
