package top.whatimiss.littlenote.modules.cost.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import top.whatimiss.littlenote.modules.cost.entity.CostEntity;

import java.util.List;
import java.util.Map;

/**
 * @author wcj
 * @create 2020/5/6  下午3:09
 * @description 费用管理的dao层
 */
@Mapper
@Component
public interface CostDao extends BaseMapper<CostEntity> {

    List<CostEntity> getList(IPage<CostEntity> page,
                             @Param("costType") String costType,
                             @Param("userId") String userId,
                             @Param("createTime") String createTime);

    List<Map<String, Object>> costTypeList();

    List<Map<String, Object>> getDailyCostByMonth(@Param("month") String month, @Param("userId") String userId);

    List<Map<String, Object>> getMonthlyCostPieChart(@Param("month") String month, @Param("userId") String userId);

    List<Map<String, Object>> getMonthlyCostByYear(@Param("year") String year, @Param("userId") String userId);

    List<Map<String, Object>> getYearlyCostPieChart(@Param("year") String year, @Param("userId") String userId);
}
