package top.whatimiss.littlenote.modules.cost.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author wcj
 * @create 2020/5/6  下午2:50
 * @description 消费的实体类
 */

@Data
@TableName("cost")
public class CostEntity {

    @TableId
    private Long id;

    /**
     * 消费类型
     */
    private String costType;

    /**
     * 消费金额
     */
    private BigDecimal cost;

    /**
     * 消费详情
     */
    private String detail;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 所属用户
     */
    private Long userId;

    /**
     *  图标
     */
    @TableField(exist = false)
    private String icon;







}
