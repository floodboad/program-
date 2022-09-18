package com.xcl.xx.ssmdemo.controller;

import com.xcl.xx.ssmdemo.common.util.IPage;
import com.xcl.xx.ssmdemo.entity.IntoParam.PageParams;
import com.xcl.xx.ssmdemo.entity.RoleVo;
import com.xcl.xx.ssmdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findr")
    @ResponseBody
    public List<RoleVo> findAll(){
        List<RoleVo> list = roleService.findAll();
        return list;
    }

    @RequestMapping("/pagingQuery")
    @ResponseBody
    public IPage<RoleVo> pagingQuery(@RequestBody PageParams params){
        IPage<RoleVo> voIPage= roleService.pagingQuery(params.getCurrent(),params.getSize());
        return voIPage;
    }



    @RequestMapping(value = "/saveSingleRole",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public void saveSingleRole(@RequestBody RoleVo roleVo){
        roleService.saveSingleRole(roleVo);
    }

}
