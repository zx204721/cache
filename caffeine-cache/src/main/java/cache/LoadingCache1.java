package cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import top.zz6628.model.simple.User;
import top.zz6628.util.Utils;

import java.util.concurrent.TimeUnit;

/**
 * Loading cache
 *
 * @author zhenz
 * @description
 * @date 2020/7/17 16:40
 */
@Slf4j
public class LoadingCache1 {

    public static LoadingCache<Long, User> createLoadingCache() {

        return Caffeine.newBuilder().maximumSize(10_000).expireAfterWrite(1, TimeUnit.SECONDS).build(key -> {
            log.info("key: {} 重新加载。", key);
            return Utils.createUser(key);
        });
    }
}
