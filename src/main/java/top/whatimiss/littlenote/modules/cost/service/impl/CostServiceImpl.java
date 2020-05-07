package top.whatimiss.littlenote.modules.cost.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.whatimiss.littlenote.common.utils.PageUtils;
import top.whatimiss.littlenote.common.utils.Query;
import top.whatimiss.littlenote.modules.cost.dao.CostDao;
import top.whatimiss.littlenote.modules.cost.entity.CostEntity;
import top.whatimiss.littlenote.modules.cost.service.CostService;

import java.util.List;
import java.util.Map;

/**
 * @author wcj
 * @create 2020/5/6  下午3:08
 * @description 费用管理的service层
 */
@Service
public class CostServiceImpl extends ServiceImpl<CostDao, CostEntity> implements CostService {


    /**
     * 获取花费明细列表
     * @param params
     * @return
     */
    @Override
    public PageUtils getList(Map params) {
        String createTime = (String) params.get("createTime");
        String costType = (String) params.get("costType");
        String userId = (String) params.get("userId");
        IPage<CostEntity> page = new Query<CostEntity>().getPage(params);
        List<CostEntity> list = this.baseMapper.getList(page,costType,userId,createTime);
        page.setRecords(list);
        return new PageUtils(page);
    }

    /**
     * 获取消费类型列表
     * @return
     */
    @Override
    public List<Map<String, Object>> costTypeList() {
        return this.baseMapper.costTypeList();
    }

    /**
     * 根据月份获取每日花费
     * @param month
     * @param userId
     * @return
     */
    @Override
    public List<Map<String, Object>> getDailyCostByMonth(String month, String userId) {
        return this.baseMapper.getDailyCostByMonth(month,userId);
    }

    /**
     * 根据月份获取每种消费类型的统计图
     * @param month
     * @param userId
     * @return
     */
    @Override
    public List<Map<String, Object>> getMonthlyCostPieChart(String month, String userId) {
        return this.baseMapper.getMonthlyCostPieChart(month,userId);
    }

    /**
     * 根据年份获取每月花费
     * @param year
     * @param userId
     * @return
     */
    @Override
    public List<Map<String, Object>> getMonthlyCostByYear(String year, String userId) {
        return this.baseMapper.getMonthlyCostByYear(year,userId);
    }

    /**
     * 获取每年消费类型的饼状图
     * @param year
     * @param userId
     * @return
     */
    @Override
    public List<Map<String, Object>> getYearlyCostPieChart(String year, String userId) {
        return this.baseMapper.getYearlyCostPieChart(year,userId);
    }
}
