package top.whatimiss.littlenote.authentication;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import top.whatimiss.littlenote.modules.user.entity.UserEntity;
import top.whatimiss.littlenote.modules.user.service.UserService;

/**
 * @author wcj
 * @create 2020/4/27 下午3:37
 * @description
 */
public class ShiroRealm extends AuthorizingRealm {

    /**注解引入业务类**/
    @Resource
    UserService userService;

    /**
     * 登录信息和用户验证信息验证(non-Javadoc)
     * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(AuthenticationToken)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String account = (String)token.getPrincipal();
        String password = new String((char[])token.getCredentials());

        UserEntity userEntity = userService.queryByAccount(account);

        /**检测是否有此用户 **/
        if(userEntity == null){
            throw new UnknownAccountException();
        }
        /**检验账号是否被锁定 **/
        if(Boolean.TRUE.equals(userEntity.getLocked())){
            throw new LockedAccountException();
        }
        /**AuthenticatingRealm使用CredentialsMatcher进行密码匹配**/
        if(null != account && null != password){
            return new SimpleAuthenticationInfo(account, password, getName());
        }else{
            return null;
        }

    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法(non-Javadoc)
     * @see AuthorizingRealm#doGetAuthorizationInfo(PrincipalCollection)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        String username = (String)pc.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        System.out.println("Shiro授权");
        return authorizationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

}
