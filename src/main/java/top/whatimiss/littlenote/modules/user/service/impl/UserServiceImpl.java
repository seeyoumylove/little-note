package top.whatimiss.littlenote.modules.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.whatimiss.littlenote.modules.user.dao.UserDao;
import top.whatimiss.littlenote.modules.user.entity.UserEntity;
import top.whatimiss.littlenote.modules.user.service.UserService;

/**
 * @author wcj
 * @create 2020/4/27  下午2:10
 * @description 用户相关的实现类
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserEntity queryByAccount(String account) {
        return userDao.queryByAccount(account);
    }
}
