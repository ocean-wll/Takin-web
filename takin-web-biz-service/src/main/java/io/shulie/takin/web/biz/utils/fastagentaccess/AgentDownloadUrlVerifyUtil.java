package io.shulie.takin.web.biz.utils.fastagentaccess;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description agent下载url校验工具类
 * @Author ocean_wll
 * @Date 2021/8/17 3:31 下午
 */
public class AgentDownloadUrlVerifyUtil {

    /**
     * 盐
     */
    private final static String SALT = "&@Ndae1#!nnj...?!";

    /**
     * 生成校验flag
     *
     * @param projectName 项目名
     * @param userAppKey  租户id
     * @param userId      用户id
     * @param version     agent版本
     * @param envCode     环境标识
     * @param expireDate  url过期时间
     * @return 唯一flag
     */
    public static String generatorFlag(String projectName, String userAppKey, String userId, String version,
        String envCode, Long expireDate) {
        int firstHash = (projectName + userAppKey + SALT + userId + version + SALT + expireDate).hashCode();
        int secondHash = (userId + SALT + firstHash + envCode).hashCode();
        int thirdHash = (SALT + secondHash + SALT + userAppKey).hashCode();
        return String.valueOf(thirdHash);
    }

    /**
     * 校验flag是否正确
     *
     * @param projectName 项目名
     * @param userAppKey  租户id
     * @param userId      用户id
     * @param version     agent版本
     * @param envCode     环境标识
     * @param expireDate  url过期时间
     * @param flag        需要校验的flag
     * @return true：校验通过，false：校验失败
     */
    public static Boolean checkFlag(String projectName, String userAppKey, String userId, String version,
        String envCode, Long expireDate, String flag) {
        if (StringUtils.isBlank(flag)) {
            return false;
        }
        return flag.equals(generatorFlag(projectName, userAppKey, userId, version, envCode, expireDate));
    }
}
