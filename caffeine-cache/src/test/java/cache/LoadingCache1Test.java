package cache;

import com.github.benmanes.caffeine.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import top.zz6628.model.simple.User;
import top.zz6628.util.Utils;

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
            User user = loadingCache.get((long) i);
        }

        for (int i = 0; i < 10; i++) {
            User user = loadingCache.get((long) i);
        }
        loadingCache.refresh(1L);
        log.info("==================");
        Thread.sleep(5000);

        for (int i = 0; i < 10; i++) {
            User user = loadingCache.get((long) i);
        }
    }

    @Test
    void testGetLoad() {
        LoadingCache<Long, User> loadingCache = LoadingCache1.createLoadingCache();

        User user = loadingCache.get(1L, key -> {
            log.info("sync log");
            return Utils.createUser(key);
        });

        User user2 = loadingCache.get(2L);
    }
}