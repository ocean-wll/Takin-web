package io.shulie.takin.web.biz.cache.webimpl;

/**
 * @author hengyu
 * @description
 * @date 6:01 下午 2021/5/10
 **/

import com.pamirs.takin.entity.dao.confcenter.TApplicationMntDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author hengyu
 * create: 2021-04-14
 * 缓存检测应用是否存在结果
 */
@Component
public class ApplicationRegisterCache {

    public static final String CACHE_NAME = "t:a:c:application:register";

    @Autowired
    protected TApplicationMntDao tApplicationMntDao;

    @Autowired
    protected RedisTemplate redisTemplate;

    public Integer queryValue(Long customerId,String applicationName) {
        String key = getKey(customerId,applicationName);
        Object obj = redisTemplate.opsForValue().get(key);
        if (obj != null){
            return (Integer)obj;
        }
        int applicationExist = tApplicationMntDao.applicationExistByCustomerIdAndAppName(
            customerId, applicationName);
        redisTemplate.opsForValue().set(key,applicationExist);
        return applicationExist;
    }

    String getKey(Long customerId, String applicationName){
        StringBuilder builder = new StringBuilder();
        builder.append(CACHE_NAME).append(":");
        builder.append(customerId).append(":").append(applicationName);
        return builder.toString();
    }

}