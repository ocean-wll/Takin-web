package com.pamirs.takin.entity.domain.entity;

import java.util.Date;

/**
 * 应用配置
 *
 * @author 298403
 */
public class TApplicationMntConfig extends BaseEntity {

    /**
     * 应用配置表的主键id
     */
    private Long tamcId;

    /**
     * 应用id
     */
    private Long applicationId;

    /**
     * 堆栈作弊检查 1 检查 0 不检查
     */
    private Integer cheatCheck;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 全参数 构造函数
     *
     * @param tamcId
     * @param applicationId
     * @param cheatCheck
     * @param createTime
     * @param updateTime
     */
    public TApplicationMntConfig(Long tamcId, Long applicationId, Integer cheatCheck, Date createTime,
        Date updateTime) {
        this.tamcId = tamcId;
        this.applicationId = applicationId;
        this.cheatCheck = cheatCheck;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     * 空构造函数
     */
    public TApplicationMntConfig() {
        super();
    }

    /**
     * 获取主键
     *
     * @return
     */
    public Long getTamcId() {
        return tamcId;
    }

    /**
     * 设置主键
     *
     * @param tamcId
     */
    public void setTamcId(Long tamcId) {
        this.tamcId = tamcId;
    }

    /**
     * 获取应用id
     *
     * @return
     */
    public Long getApplicationId() {
        return applicationId;
    }

    /**
     * 设置应用id
     *
     * @param applicationId
     */
    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * 获取作弊检查
     *
     * @return
     */
    public Integer getCheatCheck() {
        return cheatCheck;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_application_mnt_config.CHEAT_CHECK
     *
     * @param cheatCheck the value for t_application_mnt_config.CHEAT_CHECK
     * @mbggenerated
     */
    public void setCheatCheck(Integer cheatCheck) {
        this.cheatCheck = cheatCheck;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_application_mnt_config.CREATE_TIME
     *
     * @return the value of t_application_mnt_config.CREATE_TIME
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_application_mnt_config.CREATE_TIME
     *
     * @param createTime the value for t_application_mnt_config.CREATE_TIME
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_application_mnt_config.UPDATE_TIME
     *
     * @return the value of t_application_mnt_config.UPDATE_TIME
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_application_mnt_config.UPDATE_TIME
     *
     * @param updateTime the value for t_application_mnt_config.UPDATE_TIME
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
