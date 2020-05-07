package top.whatimiss.littlenote.modules.cost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.whatimiss.littlenote.common.entity.Result;
import top.whatimiss.littlenote.common.utils.PageUtils;
import top.whatimiss.littlenote.modules.cost.entity.CostEntity;
import top.whatimiss.littlenote.modules.cost.service.CostService;

import java.util.List;
import java.util.Map;

/**
 * @author wcj
 * @create 2020/5/6  下午3:05
 * @description 花费管理的controller
 */
@RestController
@RequestMapping("cost")
public class CostController {


    private final CostService costService;


    @Autowired
    public CostController(CostService costService) {
        this.costService = costService;
    }

    /**
     * 获取花费明细
     *
     * @param params
     * @return
     */
    @RequestMapping("list")
    public Result getList(@RequestParam Map params) {
        PageUtils pageUtils = costService.getList(params);
        return Result.success(pageUtils);
    }

    /**
     * 新建日记
     *
     * @return
     */
    @PostMapping("add")
    public Result add(@RequestBody CostEntity costEntity) {
        costService.save(costEntity);
        return Result.success();
    }

    /**
     * 获取消费类型列表
     *
     * @return
     */
    @GetMapping("costTypeList")
    public Result costTypeList() {
        List<Map<String, Object>> mapList = costService.costTypeList();
        return Result.success(mapList);
    }

    /**
     * 获取某月每日的花费统计
     * @return
     */
    @GetMapping("getDailyCostByMonth")
    public Result getDailyCostByMonth(@RequestParam String month,@RequestParam String userId) {
        List<Map<String, Object>> mapList = costService.getDailyCostByMonth(month, userId);
        return Result.success(mapList);
    }

    /**
     * 获取每月花费的类型的饼状图
     * @return
     */
    @GetMapping("getMonthlyCostPieChart")
    public Result getMonthlyCostPieChart(@RequestParam String month,@RequestParam String userId) {
        List<Map<String, Object>> mapList = costService.getMonthlyCostPieChart(month, userId);
        return Result.success(mapList);
    }


    /**
     * 获取年每月的花费统计
     * @return
     */
    @GetMapping("getMonthlyCostByYear")
    public Result getMonthlyCostByYear(@RequestParam String year,@RequestParam String userId) {
        List<Map<String, Object>> mapList = costService.getMonthlyCostByYear(year, userId);
        return Result.success(mapList);
    }

    /**
     * 获取每年花费的类型的饼状图
     * @return
     */
    @GetMapping("getYearlyCostPieChart")
    public Result getYearlyCostPieChart(@RequestParam String year,@RequestParam String userId) {
        List<Map<String, Object>> mapList = costService.getYearlyCostPieChart(year, userId);
        return Result.success(mapList);
    }




}
