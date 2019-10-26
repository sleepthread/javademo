package com.ewater.springboot_security.security;

import com.ewater.springboot_security.entity.SysPermission;
import com.ewater.springboot_security.service.SysPermissionService;
import com.ewater.springboot_security.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {
    @Autowired
    private SysPermissionService permissionService;
    @Autowired
    private SysRoleService roleService;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object targetPermission) {

        /**
         * authentication.getPrincipal()返回的是字符串而不是User对象 -》主要是因为构造Token的参数出错了，
         　　　　　　* 在《SpringBoot集成Spring Security（4）——自定义表单登录》中，
         　　　　　　* 实现AuthenticationProvider接口的authenticate()方法的返回值应该改成
         　　　　　　* return new UsernamePasswordAuthenticationToken(userDetails, inputPassword, userDetails.getAuthorities());
         　　　　　　* 就是将inputName改成userDetails（就是用户对象）
         */
        // 获得loadUserByUsername()方法的结果
        // User user = (User)authentication.getPrincipal();
        // 获得loadUserByUsername()中注入的角色
        // Collection<GrantedAuthority> authorities = user.getAuthorities();
        // 也可以使用authentication.getAuthorities()方法来获取对象
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) authentication.getAuthorities();

        // 遍历用户所有角色
        for(GrantedAuthority authority : authorities) {
            String roleName = authority.getAuthority();
            Integer roleId = roleService.selectByName(roleName).getId();
            // 得到角色所有的权限
            List<SysPermission> permissionList = permissionService.listByRoleId(roleId);

            // 遍历permissionList
            for(SysPermission sysPermission : permissionList) {
                // 获取权限集
                List permissions = sysPermission.getPermissions();
                // 如果访问的Url和权限用户符合的话，返回true
                if(targetUrl.equals(sysPermission.getUrl())
                        && permissions.contains(targetPermission)) {
                    return true;
                }
            }

        }

        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
