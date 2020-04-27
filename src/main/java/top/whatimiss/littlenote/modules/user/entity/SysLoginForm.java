package top.whatimiss.littlenote.modules.user.entity;

import lombok.Data;

/**
 * 登录表单
 */
@Data
public class SysLoginForm {
    private String account;
    private String password;
}
