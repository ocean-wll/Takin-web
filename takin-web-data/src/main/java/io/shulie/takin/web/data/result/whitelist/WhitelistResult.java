package io.shulie.takin.web.data.result.whitelist;

import java.util.Date;

import lombok.Data;

/**
 * @author 无涯
 * @date 2021/4/12 4:18 下午
 */
@Data
public class WhitelistResult {
    /**
     * 主键id
     */
    private Long wlistId;

    /**
     * 接口名称
     */
    private String interfaceName;

    /**
     * 白名单类型
     */
    private String type;

    /**
     * 字典分类
     */
    private String dictType;

    private Long applicationId;

    /**
     * 负责人工号
     */
    private String principalNo;

    /**
     * 是否可用(0表示未启动,1表示启动,2表示启用未校验)
     */
    private Integer useYn;

    /**
     * 租户id
     */
    private Long customerId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 插入时间
     */
    private Date createTime;

    /**
     * 变更时间
     */
    private Date updateTime;

    /**
     * 队列名称，TYPE=5时该字段才会有值
     */
    private String queueName;

    /**
     * MQ类型, 1ESB 2IBM 3ROCKETMQ 4DPBOOT_ROCKETMQ
     */
    private String mqType;

    /**
     * IP端口,如1.1.1.1:8080,集群时用逗号分隔;当且仅当TYPE=5,MQ_TYPE=(3,4)时才会有值
     */
    private String ipPort;

    /**
     * HTTP类型：1页面 2接口
     */
    private Integer httpType;

    /**
     * 页面分类：1普通页面加载 2简单查询页面/复杂界面 3复杂查询页面
     */
    private Integer pageLevel;

    /**
     * 接口类型：1简单操作/查询 2一般操作/查询 3复杂操作 4涉及级联嵌套调用多服务操作 5调用外网操作
     */
    private Integer interfaceLevel;

    /**
     * JOB调度间隔：1调度间隔≤1分钟 2调度间隔≤5分钟 3调度间隔≤15分钟 4调度间隔≤60分钟
     */
    private Integer jobInterval;

    /**
     * 是否全局
     */
    private Boolean isGlobal;

    /**
     * 生效应用
     */
    private String effectiveAppName;

    /**
     * 是否手工添加
     */
    private Boolean isHandwork;

}
