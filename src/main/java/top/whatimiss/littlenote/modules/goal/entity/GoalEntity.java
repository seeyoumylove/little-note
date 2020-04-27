package top.whatimiss.littlenote.modules.goal.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * @author wcj
 * @create 2020/4/27 下午5:11
 * @description 目标模块的实体类
 */
@Data
public class GoalEntity implements Serializable {
    private static final long serialVersionUID = 187799968911926526L;

    @TableId
    private Long id;
    /**
     * 目标名称
     */
    private String name;
    /**
     * 目标值
     */
    private BigDecimal goalValue;
    /**
     * 当前值
     */
    private BigDecimal currentValue;
    /**
     * 所属用户
     */
    private Long userId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private String process;
}