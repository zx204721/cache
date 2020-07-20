package cache;

import com.github.benmanes.caffeine.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import top.zz6628.model.simple.User;

/**
 * @author zhenz
 * @description
 * @date 2020/7/17 16:52
 */
@Slf4j
class LoadingCache1Test {

    @Test
    void createLoadingCache() throws InterruptedException {
        LoadingCache<Long, User> loadingCache = LoadingCache1.createLoadingCache();

        for (int i = 0; i < 10; i++) {
            User user = loadingCache.get((long)i);
        }

        for (int i = 0; i < 10; i++) {
            User user = loadingCache.get((long)i);
        }
        log.info("==================");
        Thread.sleep(1000);

        for (int i = 0; i < 10; i++) {
            User user = loadingCache.get((long)i);
        }
    }
}