package com.ewater.jwt_security.service;

import com.ewater.jwt_security.entity.SysUser;
import com.ewater.jwt_security.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {
    @Autowired
    private SysUserMapper userMapper;

    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public SysUser selectByUsername(String username) {
        return userMapper.selectByUserame(username);
    }
}
