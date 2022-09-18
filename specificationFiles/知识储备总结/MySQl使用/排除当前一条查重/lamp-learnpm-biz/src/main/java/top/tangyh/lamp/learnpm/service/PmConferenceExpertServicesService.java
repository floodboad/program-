package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsExpertInfo;
import top.tangyh.lamp.learnpm.entity.PmConferenceExpertServices;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmConferenceExpertServices;
import top.tangyh.lamp.learnpm.vo.query.PmConferenceExpertServicesPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmConferenceExpertServicesResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmConferenceExpertServicesSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmConferenceExpertServicesUpdateVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 会议专家劳务业务接口
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
public interface PmConferenceExpertServicesService extends SuperService<Long, PmConferenceExpertServices, PmConferenceExpertServicesSaveVO, PmConferenceExpertServicesUpdateVO, PmConferenceExpertServicesPageQuery, PmConferenceExpertServicesResultVO> {
    PmConferenceExpertServices getOldRecord(Long id);

}
