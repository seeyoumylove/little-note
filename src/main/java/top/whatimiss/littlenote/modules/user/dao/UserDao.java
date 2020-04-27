package top.whatimiss.littlenote.modules.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import top.whatimiss.littlenote.modules.user.entity.UserEntity;

/**
 * @author wcj
 * @create 2020/4/27  下午3:17
 * @description
 */
@Component
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

    UserEntity queryByAccount(@Param("account") String account);
}
