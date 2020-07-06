package cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;
import model.DataObject;

import java.util.concurrent.TimeUnit;

/**
 * @author zhenz
 * @description
 * @date 2020/7/6 14:12
 */
public class Cache1 {

    /**
     * 创建缓存实体
     * @return
     */
    public static Cache<String, DataObject> createCache() {
        return Caffeine.newBuilder()
                .removalListener((String key, DataObject dataObject, RemovalCause cause) ->
                        System.out.printf("Key %s was removed (%s)%n", key, cause))
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .maximumSize(10_000)
                .build();
    }
}
