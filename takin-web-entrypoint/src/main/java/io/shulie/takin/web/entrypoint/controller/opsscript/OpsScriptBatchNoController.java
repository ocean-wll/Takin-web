package io.shulie.takin.web.entrypoint.controller.opsscript;

import io.shulie.takin.common.beans.annotation.ModuleDef;
import io.shulie.takin.web.common.constant.APIUrls;
import io.shulie.takin.web.biz.constant.BizOpConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 运维脚本批次号表(OpsScriptBatchNo)表控制层
 *
 * @author caijy
 * @since 2021-06-16 10:43:56
 */
@RestController
@RequestMapping(APIUrls.TAKIN_API_URL + "opsScriptBatchNo")
@Api(tags = "")
public class OpsScriptBatchNoController {

    @ApiOperation("")
    @GetMapping
    @ModuleDef(
            moduleName = BizOpConstants.Modules.APPLICATION_MANAGE,
            subModuleName = BizOpConstants.SubModules.SHADOW_DATABASE_TABLE,
            logMsgKey = BizOpConstants.Message.MESSAGE_SHADOW_DATABASE_TABLE_CREATE
    )
    public void index() {

    }

}
