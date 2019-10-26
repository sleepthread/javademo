package com.ewater.springboot_security.service;

import com.ewater.springboot_security.entity.SysRole;
import com.ewater.springboot_security.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleService {
    @Autowired
    private SysRoleMapper roleMapper;

    public SysRole selectById(Integer id){
        return roleMapper.selectById(id);
    }
    public  SysRole selectByName(String name){return  roleMapper.selectByName(name);}
}
