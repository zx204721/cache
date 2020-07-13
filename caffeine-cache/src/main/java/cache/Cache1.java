package cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;
import top.zz6628.model.DataObject;
import top.zz6628.model.simple.User;

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
//                .expireAfterWrite(10, TimeUnit.SECONDS)
                .expireAfterAccess(10, TimeUnit.SECONDS)
                .maximumSize(10_000)
                .build();
    }

    /**
     * 创建缓存实体
     * @return
     */
    public static Cache<Integer, User> createUserCache() {
        return Caffeine.newBuilder()
                .removalListener((Integer id, User user, RemovalCause cause) ->
                        System.out.printf("id %s was removed (%s)%n", id, cause))
                .expireAfterWrite(10, TimeUnit.SECONDS)
//                .expireAfterAccess(10, TimeUnit.SECONDS)
                .maximumSize(10_000)
                .build();
    }
}
