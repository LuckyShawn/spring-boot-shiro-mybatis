package com.shawn.springbootshiromybatis.shiro;

import com.shawn.springbootshiromybatis.dao.UserDao;
import com.shawn.springbootshiromybatis.dao.UserPermissionDao;
import com.shawn.springbootshiromybatis.dao.UserRoleDao;
import com.shawn.springbootshiromybatis.entites.Permission;
import com.shawn.springbootshiromybatis.entites.Role;
import com.shawn.springbootshiromybatis.entites.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: TODO
 * @Author: yang.xiao
 * @Date: 2018/12/25 0025
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private UserPermissionDao userPermissionDao;
    /**
     * 获取用户角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        String userName = user.getUserName();
        System.out.println("用户" + userName + "获取权限-----ShiroRealm.doGetAuthorizationInfo");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //获取用户角色集合
        List<Role> listRole =  userRoleDao.findByUserName(userName);
        Set<String> set = new HashSet<>();
        for(Role role : listRole){
            set.add(role.getName());
        }
        simpleAuthorizationInfo.setRoles(set);

        //获取用户权限集
        List<Permission> listPermission = userPermissionDao.findByUserName(userName);
        Set<String> permissionSet = new HashSet<String>();
        for(Permission permission : listPermission){
            permissionSet.add(permission.getName());
        }
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取用户输入的用户名和密码
        String userName = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        System.out.println("用户：" + userName +"密码："+password+ "---认证---ShiroRealm.doGetAuthenticationInfo");

        // 通过用户名到数据库查询用户信息
        User user = userDao.findByUserName(userName);

        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        if (user.getStatus().equals("0")) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, password, getName());
        return simpleAuthenticationInfo;
    }
}
