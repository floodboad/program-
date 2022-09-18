package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsLongzhuMeetingType;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsLongzhuMeetingType;
import top.tangyh.lamp.learnpm.vo.query.MsLongzhuMeetingTypePageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsLongzhuMeetingTypeResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsLongzhuMeetingTypeSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsLongzhuMeetingTypeUpdateVO;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 会议类型七龙珠配置业务接口
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-28
 */
public interface MsLongzhuMeetingTypeService extends SuperService<Long, MsLongzhuMeetingType, MsLongzhuMeetingTypeSaveVO, MsLongzhuMeetingTypeUpdateVO, MsLongzhuMeetingTypePageQuery, MsLongzhuMeetingTypeResultVO> {

    // 返回所有类型的费用名称用来参照
    ArrayList<String> returnFeeNameList();
}
