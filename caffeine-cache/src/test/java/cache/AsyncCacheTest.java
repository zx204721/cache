package cache;

import com.github.benmanes.caffeine.cache.AsyncCache;
import org.junit.jupiter.api.Test;
import top.zz6628.model.simple.User;
import top.zz6628.util.Utils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author zhenz
 * @description
 * @date 2020/7/20 14:12
 */
public class AsyncCacheTest {

    @Test
    void test() throws ExecutionException, InterruptedException {
        AsyncCache<Long, User> asyncCache = AsyncCache1.create();

        CompletableFuture<User> userCompletableFuture = asyncCache.get(1L, key -> Utils.createUser(1L, 1000));
        User user = userCompletableFuture.get();
    }
}
