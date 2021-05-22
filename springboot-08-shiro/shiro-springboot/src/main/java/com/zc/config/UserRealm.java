package com.zc.config;

import com.zc.pojo.User;
import com.zc.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserServiceImpl userService;

    //  授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //  拿到当前登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser =(User) subject.getPrincipal();

        //  设置当前用户的权限
        info.addStringPermission(currentUser.getPermis());

        return info;
    }

    //  认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了=>认证doGetAuthorizationInfo");

        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;

        //  连接真实数据库
        User user = userService.queryUserByName(userToken.getUsername());
        if(user == null) {  //没有该用户
            return null;
        }

        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
