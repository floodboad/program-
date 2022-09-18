package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmExpertReplaceRecord;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmExpertReplaceRecord;
import top.tangyh.lamp.learnpm.vo.query.PmExpertReplaceRecordPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmExpertReplaceRecordResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmConferenceExpertServicesSaveVO;
import top.tangyh.lamp.learnpm.vo.save.PmExpertReplaceRecordSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmConferenceExpertServicesUpdateVO;
import top.tangyh.lamp.learnpm.vo.update.PmExpertReplaceRecordUpdateVO;
/**
 * <p>
 * 专家更换记录业务接口
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
public interface PmExpertReplaceRecordService extends SuperService<Long, PmExpertReplaceRecord, PmExpertReplaceRecordSaveVO, PmExpertReplaceRecordUpdateVO, PmExpertReplaceRecordPageQuery, PmExpertReplaceRecordResultVO> {
    /**
     * 更新信息表时，将新数据记录下来
     * @param s
     * @return
     */
    PmExpertReplaceRecord saveRecord(PmConferenceExpertServicesUpdateVO s);
}
