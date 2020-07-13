package cache;

import com.github.benmanes.caffeine.cache.Cache;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import top.zz6628.model.DataObject;
import top.zz6628.model.simple.User;
import top.zz6628.util.Utils;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author zhenz
 * @description
 * @date 2020/7/6 14:16
 */
class Cache1Test {

    static Cache<String, DataObject> cache;

    @BeforeAll
    public static void init() {
        cache = Cache1.createCache();
    }

    @Test
    void test1() throws InterruptedException {
        String key = "a";

        DataObject dataObject = cache.getIfPresent(key);
        assertNull(dataObject);

        cache.put(key, DataObject.get("haha"));
        dataObject = cache.getIfPresent(key);
        assertNotNull(dataObject);

        cache.invalidateAll(Collections.singletonList(key));

        cache.put(key, DataObject.get("haha"));

        dataObject = cache.getIfPresent(key);
        assertNotNull(dataObject);
        Thread.sleep(10000);
        dataObject = cache.getIfPresent(key);
        assertNull(dataObject);
    }

    @Test
    void testUser() {

        String md5 = Utils.md5("1234567");
        User user = new User(1, "张三李四", md5);

        Cache<Integer, User> cache = Cache1.createUserCache();

        cache.put(1, user);

        for (int i = 0; i < 10000; i++) {
            cache.put(1, user);
        }

    }
}