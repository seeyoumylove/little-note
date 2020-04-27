package top.whatimiss.littlenote.modules.user.service;

import top.whatimiss.littlenote.modules.user.entity.UserEntity;

/**
 * @author wcj
 * @create 2020/4/27  下午3:15
 * @description
 */
public interface UserService {
    UserEntity queryByAccount(String account);
}
