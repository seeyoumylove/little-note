package top.whatimiss.littlenote.modules.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 系统用户
 */
@Data
@TableName("sys_user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId
    private Long userId;

    /**
     * 登录名
     */
    @NotBlank(message = "登录名")
    private String account;

    /**
     * 用户名称
     */
    @NotBlank(message = "用户名不能为空")
    private String name;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 邮箱
     */
    @NotBlank(message="邮箱不能为空")
    @Email(message="邮箱格式不正确")
    private String email;

    /**
     * 手机号
     */
    private String mobile;


    /**
     * 是否锁定 0正常 1锁定
     */
    private Boolean locked;

}
