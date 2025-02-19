package io.shulie.takin.web.data.model.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * http-client配置模版表(HttpClientConfigTemplate)实体类
 *
 * @author 南风
 * @date 2021-08-25 14:56:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "t_http_client_config_template")
@ToString(callSuper = true)
public class HttpClientConfigTemplateEntity extends NewBaseEntity implements Serializable {
    private static final long serialVersionUID = 321777498580060382L;

    /**
     * 中间件中文描述
     */
    private String name;

    /**
     * 中间件所属类型
     */
    private String type;

    /**
     * 中间件英文名称
     */
    private String engName;

    /**
     * 是否支持自动梳理;0:不支持;1:支持
     */
    private Integer cobmEnable;

    /**
     * 是否支持白名单;0:不支持;1:支持
     */
    private Integer whitelistEnable;

    /**
     * 是否支持返回值mock;0:不支持;1:支持
     */
    private Integer returnMockEnable;

    /**
     * 返回值mock文本
     */
    private String returnMock;

    /**
     * 是否支持转发mock;0:不支持;1:支持
     */
    private Integer forwardMockEnable;

    /**
     * 转发mock文本
     */
    private String forwardMock;

    /**
     * 1.可用，2不可用
     */
    private Integer status;

    /**
     * 标记
     */
    private String remark;

    /**
     * 备注
     */
    private String commit;

    /**
     * 租户id
     */
    private Long customerId;

    /**
     * 用户id
     */
    private Long userId;


}
