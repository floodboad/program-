package top.tangyh.lamp.learnpm.wechatcontroller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.poi.hpsf.Decimal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.tangyh.basic.base.R;


import top.tangyh.basic.interfaces.echo.EchoService;
import top.tangyh.basic.utils.BeanPlusUtil;
import top.tangyh.lamp.file.controller.FileAnyTenantController;
import top.tangyh.lamp.file.entity.Appendix;
import top.tangyh.lamp.file.entity.File;
import top.tangyh.lamp.file.service.DefAppendixService;
import top.tangyh.lamp.file.vo.param.FileUploadVO;
import top.tangyh.lamp.file.vo.result.FileResultVO;

import top.tangyh.lamp.learnpm.entity.PmProject;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingApply;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingPlanning;
import top.tangyh.lamp.learnpm.entity.PmProjectStakeholder;

import top.tangyh.lamp.learnpm.pmProjectInfo.PmProjectByvalue;
import top.tangyh.lamp.learnpm.pmProjectInfo.PmProjectInfo;
import top.tangyh.lamp.learnpm.service.*;

import top.tangyh.lamp.learnpm.wechat.*;
import top.tangyh.lamp.model.vo.save.AppendixSaveVO;
import top.tangyh.lamp.oauth.biz.OauthUserBiz;
import top.tangyh.lamp.oauth.controller.UserInfoController;
import top.tangyh.lamp.system.controller.anyone.TenantAnyoneController;
import top.tangyh.lamp.system.entity.tenant.DefUser;
import top.tangyh.lamp.system.service.tenant.DefUserService;
import top.tangyh.lamp.system.vo.update.tenant.DefUserAvatarUpdateVO;


import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * 个人信息接口
 * zyq
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/api/wechat/mine")
@Api(value = "mine", tags = " 我的")
public class DefUsersController {

    private final EchoService echoService;

    private final DefUserService defUserService;

    private final PmMeetingPlanAllocationService pmMeetingPlanAllocationManagerService;

    private final PmProjectMeetingPlanningService pmProjectMeetingPlanningService;


    private final PmPersonChargeAdjustRecordService pmPersonChargeAdjustRecordService;

    private final PmProjectService projectService;

    private final PmProjectStakeholderService pmProjectStakeholderService;

    private final PmProjectMeetingApplyService pmProjectMeetingApplyService;

    private  final DefAppendixService defAppendixService;

    // 修改头像
    ///api/oauth/anyone/getUserInfoById?_t=1656657795371
    private OauthUserBiz oauthUserBiz;
    ///system/anyone/avatar
    private final TenantAnyoneController tenantAnyoneController;
    //api/base/file/anyTenant/upload
    private final FileAnyTenantController fileAnyTenantController;

    // /api/oauth/anyone/getUserInfoById?_t=1656657795371
    private final UserInfoController userInfoController;

    public EchoService getEchoService() {
        return echoService;
    }

    // 个人信息借接口
    @ApiOperation(value = "头像展示", notes = "头像展示")
    @PostMapping(value = "/defuserList")
    @RequestMapping(value = "defuserList", method = RequestMethod.POST, produces = "application/json")
    public R defuserList(HttpServletRequest request) {

        if (WO.getUserId(request) != null) {
           Appendix appendix=defAppendixService.getByCreatBy(WO.getUserId(request));
           Long id=appendix.getId();
            String sd = String.valueOf(id);
            String idsa = sd.replaceAll(" +", "");
            String[] idss = idsa.split(",");
            Long[] convert = (Long[]) ConvertUtils.convert(idss, Long.class);
            List<Long> ids = Arrays.asList(convert);
            R<Map<Long, String>> map=fileAnyTenantController.findUrlFromDefById(ids);
            return R.success(map);// 文件的ids，根据文件的id获取文件的临时访问路径


        }
        return R.fail("用户id");


    }


    // 更换规划负责人

    @ApiOperation(value = "更换负责人", notes = "更换负责人")
    @PostMapping(value = "/updateprincipal")
    @RequestMapping(value = "updateprincipal", method = RequestMethod.POST, produces = "application/json")
    public R updateprincipal(
                             @RequestBody PmMeetingupdateproject pmProjectMeetingPlanning) {


        // 判断是否存在该用户

        if (pmProjectMeetingPlanning.getNowPrincipaId() == null) {  // 看是否是以下拉框传过来的

            DefUser defUser = defUserService.getUserByMobile(pmProjectMeetingPlanning.getNowPrincipalPhone());// 根据电话传过来的
            if (defUser == null) {
                DefUser defUser1 = defUserService.isexist(pmProjectMeetingPlanning);
                pmProjectMeetingPlanning.setNowPrincipaId(defUser1.getId());

                return R.success(pmPersonChargeAdjustRecordService.updatePrincipal(pmProjectMeetingPlanning));


            } else {
                pmProjectMeetingPlanning.setNowPrincipaId(defUser.getId());
                return R.success(pmPersonChargeAdjustRecordService.updatePrincipal(pmProjectMeetingPlanning));
            }


        } else {
            return R.success(pmPersonChargeAdjustRecordService.updatePrincipal(pmProjectMeetingPlanning));
        }


    }


    // 更换执行人

    @ApiOperation(value = "更换执行人", notes = "更换执行人")
    @PostMapping(value = "/updateprincipal1")
    @RequestMapping(value = "updateprincipal1", method = RequestMethod.POST, produces = "application/json")
    public R updateprincipal1(@RequestBody PmMeetingupdateproject pmProjectMeetingPlanning) {

        if (pmProjectMeetingPlanning.getNowPrincipaId() == null) {   // 看是否是以下拉框传过来的

            DefUser defUser = defUserService.getUserByMobile(pmProjectMeetingPlanning.getNowPrincipalPhone());
            if (defUser == null) {
                DefUser defUser1 = defUserService.isexist(pmProjectMeetingPlanning);
                pmProjectMeetingPlanning.setNowPrincipaId(defUser1.getId());
                return R.success(pmPersonChargeAdjustRecordService.updatePrincipal1(pmProjectMeetingPlanning));


            } else {
                pmProjectMeetingPlanning.setNowPrincipaId(defUser.getId());
                return R.success(pmPersonChargeAdjustRecordService.updatePrincipal1(pmProjectMeetingPlanning));
            }


        } else {
            return R.success(pmPersonChargeAdjustRecordService.updatePrincipal1(pmProjectMeetingPlanning));
        }


    }



    // 分配
    @ApiOperation(value = "分配", notes = "分配")
    @PostMapping(value = "/pmMeetingPlan")
    @RequestMapping(value = "pmMeetingPlan", method = RequestMethod.POST, produces = "application/json")
    public R pmMeetingPlan(
            @RequestBody Allocation allocation
    ) {


        DefUser defUser = defUserService.getUserByMobile(allocation.getPrincipalPhone());


            if (defUser != null) {
                allocation.setDefUserId(defUser.getId());

                return R.success(pmMeetingPlanAllocationManagerService.savemeeting(allocation));

            } else {

                DefUser defUse = defUserService.saveAllocation(allocation);
                allocation.setDefUserId(defUse.getId());
                return R.success(pmMeetingPlanAllocationManagerService.savemeeting(allocation));


            }




    }






    // 修改头像
    @ApiOperation(value = "修改头像", notes = "修改头像")
    @PostMapping(value = "/updateFile")
    @RequestMapping(value = "updateFile", method = RequestMethod.POST, produces = "application/json")
    public R updateFile(@RequestBody UpdateFile updateFile
    ) {

        DefUser defUser1 = defUserService.getUserByMobile(updateFile.getPhone());


        // 1.上传文件
        File file = File.builder().storageType(updateFile.getStorageType()).bucket(updateFile.getBucket()).bizType(updateFile.getBizType()).build();
        FileUploadVO fileUploadVO = BeanPlusUtil.toBean(file, FileUploadVO.class);

        R<FileResultVO> fileResultVOR = fileAnyTenantController.uploadDef(updateFile.getFile(), fileUploadVO);// 上传文件、得到相应的file信息


        // 2.修改头像

        File file1 = BeanPlusUtil.toBean(fileResultVOR, File.class);

        Appendix appendix = Appendix.builder().bizType(updateFile.getBizType()).fileType(file1.getFileType())
                .bucket(updateFile.getBucket()).path(file1.getPath()).originalFileName(file1.getOriginalFileName())
                .contentType(file1.getContentType()).size(file1.getSize()).id(file1.getId()).build();
        AppendixSaveVO appendixSaveVO = BeanPlusUtil.toBean(appendix, AppendixSaveVO.class);

        DefUserAvatarUpdateVO defUserAvatarUpdateVO = new DefUserAvatarUpdateVO(defUser1.getId(), appendixSaveVO);

        tenantAnyoneController.avatar(defUserAvatarUpdateVO);// ，修改头像

        //3. 查询是否是该租户的，
        userInfoController.getUserInfoById(defUser1.getId());


        // 4.根据ids得到path
        String sd = String.valueOf(file1.getId());
        String idsa = sd.replaceAll(" +", "");
        String[] idss = idsa.split(",");
        Long[] convert = (Long[]) ConvertUtils.convert(idss, Long.class);
        List<Long> ids = Arrays.asList(convert);
        R<Map<Long, String>> map=fileAnyTenantController.findUrlFromDefById(ids);
        return R.success(map);// 文件的ids，根据文件的id获取文件的临时访问路径




    }

    // 查询项目信息

    @ApiOperation(value = "项目信息", notes = "项目信息")
    @PostMapping(value = "/pmProjectInfo")
    @RequestMapping(value = "pmProjectInfo", method = RequestMethod.POST, produces = "application/json")
    public R pmProjectInfo(HttpServletRequest request,

                           @RequestBody WO wo) {



      if(WO.getPhone(request)!=null){
          DefUser defUser =defUserService.getUserByMobile(WO.getPhone(request));// 得到用户的所有信息
          PmProjectStakeholder pmProjectStakeholder=pmProjectStakeholderService.getByPhone(WO.getPhone(request));// 去判断项目干系人里面是否有这个人
          if(pmProjectStakeholder!=null){
              String role=pmProjectStakeholder.getProjectRole();// 项目干系人中差角色
              if(role.equals(03)){
                  List<PmProjectMeetingPlanning>  pm=pmProjectMeetingPlanningService.getByPhone(WO.getPhone(request));// 根据规划人电话获取会议规划的
                  List<PmProjectInfo> pmProjectInfos=new ArrayList<>();
                  for (int i=0;i<pm.size();i++){
                      PmProject pmProject=projectService.getById(pm.get(i).getPmProjectId()); //获取对应项目信息

                      String pmProjectName=pmProject.getProjectName();// 项目名称
                      String ppjihuasession=pmProject.getEstimatedMeetingTotalNum();// 计划changci
                      String ppfuzesession=pmProject.getEstimatedMeetingTotalNum();// 负责场次
                      String ppyiwansession=pmProject.getCompletedSessions(); // 已完成场次
                      Integer ppjinxingseession=pmProjectMeetingApplyService.getByPmProjectMeetingPlanningid(pm.get(i).getId()); // 进行中场次
                      Integer ppweikaisession=Integer.parseInt(ppfuzesession)-Integer.parseInt(ppyiwansession)-ppjinxingseession; //未开展场次
                      BigDecimal ppGeneralBudhet=pmProject.getTotalBudgetAmount();// 总预算
                      BigDecimal ppExecutedbudget=pmProject.getMeetingBudgetOccupied();// 已执行金额
                      BigDecimal ppSettledamount=pmProject.getActualBudgetSpent();// 已结算金额
                      PmProjectInfo pmProjectInfo=new PmProjectInfo(pmProjectName,ppjihuasession,ppfuzesession,ppyiwansession,ppjinxingseession,ppweikaisession,ppGeneralBudhet,ppExecutedbudget,ppSettledamount,null); // 查到页面上的相关内容
                      pmProjectInfos.add(pmProjectInfo);


                  }
                  return R.success(pmProjectInfos);

              }else if(role.equals(02) || role.equals(02)&&role.equals(03)){ // 判断角色是项目经理或者项目经理或者项目执行经理

                  List<PmProject> pmProjectList=projectService.getByid(defUser.getId());// 查询项目的相关信息根据用户id
                  return R.success(pmProjectList);
              }else if(role==null){
                  return null; // 没有角色

              }else{
                  List<PmProject> pmProjectList=projectService.list(null);// 可以查看全部的
                  return R.success(pmProjectList);
              }
          }else{
              return null;// 项目干系人无该人
          }

      }else{
          return R.fail("无该用户手机号");
      }


    }

//    // 项目详情信息
//    // 关于
//    @ApiOperation(value = "项目详情信息", notes = "项目详情信息")
//    @PostMapping(value = "/pmProjectInfoList")
//    @RequestMapping(value = "pmProjectInfoList", method = RequestMethod.POST, produces = "application/json")
//    public R pmProjectInfoList(HttpServletRequest request,
//
//                           @RequestBody PmProjectByvalue pmProjectByvalue) {
//
//        if(pmProjectByvalue.getPhone()!=null){
//            DefUser defUser =defUserService.getUserByMobile(pmProjectByvalue.getPhone());// 得到用户的所有信息
//            PmProjectStakeholder pmProjectStakeholder=pmProjectStakeholderService.getByPhone(pmProjectByvalue.getPhone());// 去判断项目干系人里面是否有这个人
//            if(pmProjectStakeholder!=null){
//                String role=pmProjectStakeholder.getProjectRole();// 项目干系人中差角色
//                if(role.equals(03)){
//
//                }
//            }
//        }
//
//
//
//
//        return null;
//
//    }










}
