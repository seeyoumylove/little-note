//package top.whatimiss.littlenote.common.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * @author wcj
// * @create 2020/4/27  下午2:29
// * @description 自定义登录拦截配置类
// */
//@Configuration
//public class MySecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic()
//                .and()
//                // 身份认证
//                .authorizeRequests()
//                // 所有请求
//                .anyRequest()
//                // 身份认证
//                .authenticated();
//    }
//}
