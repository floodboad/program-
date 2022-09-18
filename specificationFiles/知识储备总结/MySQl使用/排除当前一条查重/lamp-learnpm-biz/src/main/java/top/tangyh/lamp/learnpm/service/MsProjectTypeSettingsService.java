package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsProjectTypeSettings;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsProjectTypeSettings;
import top.tangyh.lamp.learnpm.vo.query.MsProjectTypeSettingsPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsProjectTypeSettingsResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsProjectTypeSettingsSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsProjectTypeSettingsUpdateVO;
/**
 * <p>
 * 项目类型设置业务接口
 * 
 * </p>
 *
 * @author zyq
 * @date 2022-06-08
 */
public interface MsProjectTypeSettingsService extends SuperService<Long, MsProjectTypeSettings, MsProjectTypeSettingsSaveVO, MsProjectTypeSettingsUpdateVO, MsProjectTypeSettingsPageQuery, MsProjectTypeSettingsResultVO> {

}
