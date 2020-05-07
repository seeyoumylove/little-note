package top.whatimiss.littlenote.modules.cost.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.whatimiss.littlenote.common.utils.PageUtils;
import top.whatimiss.littlenote.modules.cost.entity.CostEntity;

import java.util.List;
import java.util.Map;

/**
 * @author wcj
 * @create 2020/5/6  下午3:07
 * @description
 */
public interface CostService extends IService<CostEntity> {

    PageUtils getList(Map params);

    List<Map<String, Object>> costTypeList();

    List<Map<String, Object>> getDailyCostByMonth(String month, String userId);

    List<Map<String, Object>> getMonthlyCostPieChart(String month, String userId);

    List<Map<String, Object>> getMonthlyCostByYear(String year, String userId);

    List<Map<String, Object>> getYearlyCostPieChart(String year, String userId);
}
