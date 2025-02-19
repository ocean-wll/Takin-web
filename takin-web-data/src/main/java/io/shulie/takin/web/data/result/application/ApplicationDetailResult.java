package io.shulie.takin.web.data.result.application;

import java.util.Date;

import lombok.Data;

/**
 * @author fanxx
 * @date 2020/11/11 7:43 下午
 */
@Data
public class ApplicationDetailResult {
    private Long id;

    private Long applicationId;
    private String applicationName;
    private String applicationDesc;
    private String ddlScriptPath;
    private String cleanScriptPath;
    private String readyScriptPath;
    private String basicScriptPath;
    private String cacheScriptPath;
    private Long cacheExpTime;
    private Integer useYn;
    private String agentVersion;
    private Integer nodeNum;
    private Integer accessStatus;
    private String switchStatus;
    private String exceptionInfo;
    private Date createTime;
    private Date updateTime;
    private String alarmPerson;
    private String pradarVersion;
    private Long customerId;
    private Long userId;
}
