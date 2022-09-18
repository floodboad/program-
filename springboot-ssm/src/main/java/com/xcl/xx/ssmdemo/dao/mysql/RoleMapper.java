package com.xcl.xx.ssmdemo.dao.mysql;

import com.xcl.xx.ssmdemo.dao.pojo.Role;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface RoleMapper {

    List<Role> selectAll();

    List<Role> pagingQuery(int index,int size);

    void saveSingleRole(Role role);
}
