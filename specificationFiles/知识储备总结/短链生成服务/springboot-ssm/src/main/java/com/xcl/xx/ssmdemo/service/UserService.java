package com.xcl.xx.ssmdemo.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.xcl.xx.ssmdemo.dao.mysql.UserMapper;
import com.xcl.xx.ssmdemo.dao.pojo.User;
import com.xcl.xx.ssmdemo.entity.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Service中实现业务
 *  用户的CRUD操作，在此类中需要提供 增、删、改、查 4个方法
 */
@Service
//@Transactional// 注解
public class UserService {
    @Resource
    private UserMapper userMapper;


    public List<UserVO> findAll() {
        List<User> userList = userMapper.selectAll();
        List<UserVO> userVOList = new ArrayList<>();
        for (User userPO : userList) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(userPO, userVO);
            userVOList.add(userVO);
        }

        return userVOList;
    }

    public User findUserbyId(Integer id){
        User user = userMapper.selectUserbyId(id);
        return user;
    }
}

