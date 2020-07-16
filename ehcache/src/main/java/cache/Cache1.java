package cache;

import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import top.zz6628.model.simple.User;

/**
 * @author zhenz
 * @description
 * @date 2020/7/14 13:41
 */
public class Cache1 {
    public static CacheManager create() {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().withCache("user",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, User.class, ResourcePoolsBuilder.heap(10))).build();
        cacheManager.init();
        return cacheManager;
    }
}
