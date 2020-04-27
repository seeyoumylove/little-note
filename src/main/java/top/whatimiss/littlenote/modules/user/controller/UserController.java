package top.whatimiss.littlenote.modules.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.whatimiss.littlenote.common.entity.Result;
import top.whatimiss.littlenote.modules.user.entity.SysLoginForm;
import top.whatimiss.littlenote.modules.user.entity.UserEntity;
import top.whatimiss.littlenote.modules.user.service.UserService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody SysLoginForm form) throws IOException {
        //用户信息
        UserEntity userEntity = userService.queryByAccount(form.getAccount());
        //账号不存在、密码错误
        if (userEntity == null) {
            return Result.fail("账号不存在");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userEntity.getUserId());
        return Result.success(map);
    }

    /**
     * 退出
     */
    @PostMapping("/logout")
    public Result logout() {
        return Result.success();
    }
}
