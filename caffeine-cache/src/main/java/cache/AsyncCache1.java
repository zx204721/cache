package cache;

import com.github.benmanes.caffeine.cache.AsyncCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import top.zz6628.model.simple.User;

import java.util.concurrent.TimeUnit;

/**
 * AsyncCache
 *
 * @author zhenz
 * @date 2020/7/20 14:10
 */
public class AsyncCache1 {

    public static AsyncCache<Long, User> create() {

        return Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .maximumSize(10_000)
                .buildAsync();
    }
}
