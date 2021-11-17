package io.shulie.takin.web.data.dao.pradar;

import java.util.List;
import java.util.Objects;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import io.shulie.takin.common.beans.page.PagingList;
import io.shulie.takin.web.common.pojo.dto.PageBaseDTO;
import io.shulie.takin.web.common.util.CommonUtil;
import io.shulie.takin.web.data.mapper.mysql.PradarZkConfigMapper;
import io.shulie.takin.web.data.model.mysql.PradarZkConfigEntity;
import io.shulie.takin.web.data.param.pradarconfig.PagePradarZkConfigParam;
import io.shulie.takin.web.data.param.pradarconfig.PradarConfigCreateParam;
import io.shulie.takin.web.data.result.pradarzkconfig.PradarZkConfigResult;
import io.shulie.takin.web.data.util.MPUtil;
import io.shulie.takin.web.ext.util.WebPluginUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author junshao
 * @date 2021/07/08 3:20 下午
 */
@Component
public class PradarZkConfigDAOImpl implements PradarZkConfigDAO, MPUtil<PradarZkConfigEntity> {

    @Autowired
    private PradarZkConfigMapper pradarZkConfigMapper;

    @Override
    public List<PradarZkConfigResult> listSystemConfig() {
        List<PradarZkConfigEntity> result = pradarZkConfigMapper.selectList(this.getLambdaQueryWrapper()
            .select(PradarZkConfigEntity::getZkPath, PradarZkConfigEntity::getValue)
            .eq(PradarZkConfigEntity::getTenantId, WebPluginUtils.SYS_DEFAULT_TENANT_ID)
            .eq(PradarZkConfigEntity::getEnvCode, WebPluginUtils.SYS_DEFAULT_ENV_CODE));
        return CommonUtil.list2list(result, PradarZkConfigResult.class);
    }

    @Override
    public int insert(PradarConfigCreateParam createParam) {
        PradarZkConfigEntity entity = new PradarZkConfigEntity();
        BeanUtils.copyProperties(createParam, entity);
        return pradarZkConfigMapper.insert(entity);
    }

    @Override
    public boolean updateOnlySystem(PradarConfigCreateParam updateParam) {
        PradarZkConfigEntity entity = new PradarZkConfigEntity();
        BeanUtils.copyProperties(updateParam, entity);
        return SqlHelper.retBool(pradarZkConfigMapper.updateById(entity));
    }

    @Override
    public int delete(PradarConfigCreateParam deleteParam) {
        if (!Objects.isNull(deleteParam.getId())) {
            return pradarZkConfigMapper.deleteById(deleteParam.getId());
        }
        return 0;
    }

    @Override
    public PradarZkConfigResult getById(Long id) {
        return CommonUtil.copyBeanPropertiesWithNull(pradarZkConfigMapper.selectById(id), PradarZkConfigResult.class);
    }

    @Override
    public PradarZkConfigResult getByZkPath(String zkPath) {
        List<PradarZkConfigResult> configList = pradarZkConfigMapper.selectListByZkPath(zkPath,
            WebPluginUtils.traceTenantId(), WebPluginUtils.traceEnvCode());
        return configList.isEmpty() ? null : configList.get(0);
    }

    @Override
    public IPage<PradarZkConfigResult> page(PagePradarZkConfigParam param, PageBaseDTO pageBaseDTO) {
        return pradarZkConfigMapper.selectPageByTenantIdAndEnvCode(this.setPage(pageBaseDTO), param);
    }

    @Override
    public PagingList<PradarZkConfigResult> page(Long tenantId, String envCode,
        PageBaseDTO pageBaseDTO) {
        IPage<PradarZkConfigEntity> page = pradarZkConfigMapper.selectPage(this.setPage(pageBaseDTO),
            this.getLambdaQueryWrapper().select(PradarZkConfigEntity::getId, PradarZkConfigEntity::getZkPath,
                    PradarZkConfigEntity::getValue, PradarZkConfigEntity::getType, PradarZkConfigEntity::getRemark,
                    PradarZkConfigEntity::getModifyTime)
                .eq(PradarZkConfigEntity::getTenantId, tenantId)
                .eq(PradarZkConfigEntity::getEnvCode, envCode));
        if (page.getTotal() == 0) {
            return PagingList.empty();
        }

        return PagingList.of(CommonUtil.list2list(page.getRecords(), PradarZkConfigResult.class), page.getTotal());
    }

}
