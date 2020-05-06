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
}
