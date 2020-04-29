package top.whatimiss.littlenote.modules.sentence.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author wcj
 * @create 2020/4/28  下午7:32
 * @description 句子的实体
 */
@Data
@TableName("sentence")
public class SentenceEntity {

    @TableId
    private Long id;

    /**
     * 句子类型
     */
    private String sentenceType;

    /**
     * 句子
     */
    private String sentence;

    /**
     * 解释
     */
    private String explain;

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


}
