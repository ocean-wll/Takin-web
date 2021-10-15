package io.shulie.takin.web.biz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pamirs.takin.common.constant.ConfigConstants;
import com.pamirs.takin.common.constant.TakinErrorEnum;
import com.pamirs.takin.common.exception.TakinModuleException;
import com.pamirs.takin.entity.domain.entity.TBaseConfig;
import io.shulie.takin.web.biz.common.CommonService;
import io.shulie.takin.web.biz.utils.CopyUtils;
import io.shulie.takin.web.data.model.mysql.BaseConfigEntity;
import io.shulie.takin.web.ext.util.WebPluginUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 基础配置表
 */
@Service
public class BaseConfigService extends CommonService {

    /**
     * 通过主键查询
     *
     * @return
     */
    public TBaseConfig queryByConfigCode(String configCode) {
        return this.selectByPrimaryKey(configCode);;
    }

    public TBaseConfig selectByPrimaryKey(String configCode){
        QueryWrapper<BaseConfigEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("env_code", WebPluginUtils.traceEnvCode());
        wrapper.eq("tenant_id", WebPluginUtils.traceTenantId());
        wrapper.eq("CONFIG_CODE",configCode);
        BaseConfigEntity configEntity = baseConfigMapper.selectOne(wrapper);

        TBaseConfig baseConfig = new TBaseConfig();
        BeanUtils.copyProperties(configEntity,baseConfig);
        return baseConfig;
    }

    public void checkExistAndInsert(String configCode) {
        TBaseConfig config = queryByConfigCode(configCode);
        if (config != null) {
            return;
        }
        config = new TBaseConfig();
        config.setConfigCode(configCode);
        config.setConfigValue(ConfigConstants.WHITE_LIST_OPEN);
        config.setConfigDesc("白名单开关：0-关闭 1-开启");
        tbaseConfigDao.insertSelective(config);
    }

    /**
     * 更新基础配置的值
     *
     * @throws TakinModuleException
     */
    public void updateBaseConfig(TBaseConfig tBaseConfig) throws TakinModuleException {
        if (StringUtils.isEmpty(tBaseConfig.getConfigCode()) || StringUtils.isEmpty(tBaseConfig.getConfigValue())) {
            throw new TakinModuleException(TakinErrorEnum.API_TAKIN_CONFCENTER_UPDATE_BASE_CONFIG_PARAM_EXCEPTION);
        }
        if (tBaseConfig.getConfigValue().length() > 128) {
            throw new TakinModuleException(
                TakinErrorEnum.API_TAKIN_CONFCENTER_UPDATE_BASE_CONFIG_VALUE_TOO_LONG_EXCEPTION);
        }
        tbaseConfigDao.updateByPrimaryKeySelective(tBaseConfig);

    }

    /**
     * 更新基础配置的值
     *
     * @throws TakinModuleException
     */
    public void addBaseConfig(TBaseConfig tBaseConfig) throws TakinModuleException {
        if (StringUtils.isEmpty(tBaseConfig.getConfigCode()) || StringUtils.isEmpty(tBaseConfig.getConfigValue())) {
            throw new TakinModuleException(TakinErrorEnum.API_TAKIN_CONFCENTER_ADD_BASE_CONFIG_EXCEPTION);
        }
        TBaseConfig source = this.selectByPrimaryKey(tBaseConfig.getConfigCode());
        if (source != null) {
            throw new TakinModuleException(TakinErrorEnum.API_TAKIN_CONFCENTER_ADD_BASE_CONFIG_EXIST);
        }
        tBaseConfig.setEnvCode(WebPluginUtils.traceEnvCode());
        tBaseConfig.setTenantId(WebPluginUtils.traceTenantId());
        tbaseConfigDao.insertSelective(tBaseConfig);
    }

}
