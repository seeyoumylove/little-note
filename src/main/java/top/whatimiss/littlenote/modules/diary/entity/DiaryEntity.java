package top.whatimiss.littlenote.modules.diary.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author wcj
 * @create 2020/4/28  下午5:44
 * @description 日记实体
 */
@Data
@TableName("diary")
public class DiaryEntity {

    @TableId
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 日记类型
     */
    private String diaryType;

    /**
     * 日记内容
     */
    private String content;

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
    private String userId;

}
