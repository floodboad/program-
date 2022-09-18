package com.xcl.xx.ssmdemo.service;

import com.xcl.xx.ssmdemo.common.util.IPage;
import com.xcl.xx.ssmdemo.dao.mysql.RoleMapper;
import com.xcl.xx.ssmdemo.dao.pojo.Role;
import com.xcl.xx.ssmdemo.dao.pojo.User;
import com.xcl.xx.ssmdemo.entity.RoleVo;
import com.xcl.xx.ssmdemo.entity.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
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

    public IPage<RoleVo> pagingQuery(int current, int size) {
        log.info("进入分页方法："+current);
        List<Role> roleList= roleMapper.pagingQuery((current-1)*size,size);
        List<Role> roleList1= roleMapper.selectAll();
        List<RoleVo> roleVoList = new ArrayList<>();
        for (Role rolePo : roleList) {
            RoleVo roleVo = new RoleVo();
            BeanUtils.copyProperties(rolePo, roleVo);
            roleVoList.add(roleVo);
        }
        //int totalPages = roleList1.size()/size +1;
        //IPage<RoleVo> page = new IPage<>(current ,size,roleList1.size(),totalPages,roleVoList);

        IPage<RoleVo> page = new IPage<>();
        page.setPageSize(size);
        page.setTotalCount(roleList1.size());
        page.setPageNum(current);
        page.setPageList(roleVoList);
        log.info("对象roleVoList："+roleVoList+"+IPage的cuurent+"+page.getPageNo());
        return page;
    }
}
