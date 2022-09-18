package com.xcl.xx.ssmdemo.service;

import com.xcl.xx.ssmdemo.dao.mysql.RoleMapper;
import com.xcl.xx.ssmdemo.dao.pojo.Role;
import com.xcl.xx.ssmdemo.dao.pojo.User;
import com.xcl.xx.ssmdemo.entity.RoleVo;
import com.xcl.xx.ssmdemo.entity.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    @Resource
    private RoleMapper roleMapper;

    public List<RoleVo> findAll(){
        List<Role> roleList= roleMapper.selectAll();
        List<RoleVo> roleVoList = new ArrayList<>();
        for (Role rolePo : roleList) {
            RoleVo roleVo = new RoleVo();
            BeanUtils.copyProperties(rolePo, roleVo);
            roleVoList.add(roleVo);
        }

        return roleVoList;
    }


    public void saveSingleRole(RoleVo roleVo) {
        Role role = new Role();
        BeanUtils.copyProperties(roleVo,role);
        roleMapper.saveSingleRole(role);
    }
}
