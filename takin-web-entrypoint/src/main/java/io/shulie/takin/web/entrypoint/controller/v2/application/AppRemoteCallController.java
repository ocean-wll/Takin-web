package io.shulie.takin.web.entrypoint.controller.v2.application;

import io.shulie.takin.common.beans.annotation.ActionTypeEnum;
import io.shulie.takin.common.beans.annotation.AuthVerification;
import io.shulie.takin.common.beans.annotation.ModuleDef;
import io.shulie.takin.common.beans.component.SelectVO;
import io.shulie.takin.web.biz.constant.BizOpConstants;
import io.shulie.takin.web.biz.pojo.output.application.AppRemoteCallOutputV2;
import io.shulie.takin.web.biz.pojo.request.application.AppRemoteCallCreateV2Request;
import io.shulie.takin.web.biz.pojo.request.application.AppRemoteCallDelV2Request;
import io.shulie.takin.web.biz.pojo.request.application.AppRemoteCallUpdateV2Request;
import io.shulie.takin.web.biz.pojo.response.application.AppRemoteCallStringResponse;
import io.shulie.takin.web.biz.pojo.response.application.AppRemoteCallV2Response;
import io.shulie.takin.web.biz.service.linkManage.AppRemoteCallService;
import io.shulie.takin.web.common.common.Response;
import io.shulie.takin.web.common.constant.APIUrls;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author 南风
 * @date 2021/8/25 11:25 上午
 */
@Slf4j
@RestController("v2.application.remote")
@RequestMapping(APIUrls.TAKIN_API_URL+"v2")
@Api(tags = "接口-v2:远程调用", value = "远程调用管理接口")
public class AppRemoteCallController {

    @Resource
    private AppRemoteCallService appRemoteCallService;

    @ApiOperation("远程接口配置类型可用性筛选")
    @GetMapping("/application/remote/call/config/select")
    @AuthVerification(
        moduleCode = BizOpConstants.ModuleCode.APPLICATION_MANAGE,
        needAuth = ActionTypeEnum.QUERY
    )
    public List<SelectVO> getConfigSelect(@ApiParam(name = "interfaceType",value = "接口类型",required = true)
                                              @RequestParam("interfaceType") String interfaceType) {
        return appRemoteCallService.getConfigSelectV2(interfaceType);
    }

    @ApiOperation("远程接口类型可用性筛选")
    @GetMapping("/application/remote/call/interface/type/select")
    @AuthVerification(
            moduleCode = BizOpConstants.ModuleCode.APPLICATION_MANAGE,
            needAuth = ActionTypeEnum.QUERY
    )
    public List<SelectVO> getInterfaceTypeSelect() {
        return appRemoteCallService.getInterfaceTypeSelect();
    }

    @ApiOperation("远程调用添加接口")
    @PostMapping("/application/remote/call/add")
    @ModuleDef(
            moduleName = BizOpConstants.Modules.APPLICATION_MANAGE,
            subModuleName = BizOpConstants.SubModules.REMOTE_CALL,
            logMsgKey = BizOpConstants.Message.MESSAGE_REMOTE_CALL_CREATE
    )
    @AuthVerification(
            moduleCode = BizOpConstants.ModuleCode.APPLICATION_MANAGE,
            needAuth = ActionTypeEnum.CREATE
    )
    public AppRemoteCallStringResponse insert(@ApiParam(required=true) @Valid @RequestBody AppRemoteCallCreateV2Request request) {
        appRemoteCallService.create(request);
        return new AppRemoteCallStringResponse("操作成功");
    }

    @ApiOperation("远程调用编辑接口")
    @PostMapping("/application/remote/call/update")
    @ModuleDef(
            moduleName = BizOpConstants.Modules.APPLICATION_MANAGE,
            subModuleName = BizOpConstants.SubModules.REMOTE_CALL,
            logMsgKey = BizOpConstants.Message.MESSAGE_REMOTE_CALL_CREATE
    )
    @AuthVerification(
            moduleCode = BizOpConstants.ModuleCode.APPLICATION_MANAGE,
            needAuth = ActionTypeEnum.UPDATE
    )
    public AppRemoteCallStringResponse update(@ApiParam(required=true) @Valid @RequestBody AppRemoteCallUpdateV2Request request) {
        appRemoteCallService.updateV2(request);
        return new AppRemoteCallStringResponse("操作成功");
    }

    @ApiOperation("远程调用详情接口")
    @GetMapping("/application/remote/call/detail")
    @AuthVerification(
            moduleCode = BizOpConstants.ModuleCode.APPLICATION_MANAGE,
            needAuth = ActionTypeEnum.QUERY
    )
    public AppRemoteCallV2Response getById(@ApiParam(name = "id",value = "记录id",required = true) @RequestParam("id") Long id) {
        AppRemoteCallOutputV2 output = appRemoteCallService.getByIdV2(id);
        AppRemoteCallV2Response response = new AppRemoteCallV2Response();
        BeanUtils.copyProperties(output, response);
        return response;
    }


    @ApiOperation("远程调用删除接口")
    @DeleteMapping("/application/remote/call/delete")
    @AuthVerification(
            moduleCode = BizOpConstants.ModuleCode.APPLICATION_MANAGE,
            needAuth = ActionTypeEnum.DELETE
    )
    public Response delete(@ApiParam(required=true) @Valid @RequestBody AppRemoteCallDelV2Request request) {
        appRemoteCallService.deleteById(request.getId());
        return Response.success();
    }
}
