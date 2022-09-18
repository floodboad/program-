package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsAudienceInfo;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsAudienceInfo;
import top.tangyh.lamp.learnpm.vo.query.MsAudienceInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsAudienceInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsAudienceInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsAudienceInfoUpdateVO;
/**
 * <p>
 * 听众信息表业务接口
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
public interface MsAudienceInfoService extends SuperService<Long, MsAudienceInfo, MsAudienceInfoSaveVO, MsAudienceInfoUpdateVO, MsAudienceInfoPageQuery, MsAudienceInfoResultVO> {

    // 查询数据库中是否有电话号码的听众或用户后再保存.true表示可以添加，false不能添加
    boolean uniquePhoneNumsSave(String phoneNums);
}
