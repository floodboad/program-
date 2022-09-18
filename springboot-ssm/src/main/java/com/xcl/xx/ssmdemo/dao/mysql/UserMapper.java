package com.xcl.xx.ssmdemo.dao.mysql;


import com.xcl.xx.ssmdemo.dao.pojo.User;

import java.util.List;

@org.apache.ibatis.annotations.Mapper // mybatis
public interface UserMapper  {

    List<User> selectAll();

    User selectUserbyId(Integer id);

}
