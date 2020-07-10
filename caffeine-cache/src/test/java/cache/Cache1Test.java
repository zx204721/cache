package cache;

import com.github.benmanes.caffeine.cache.Cache;
import model.DataObject;
import model.simple.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sun.security.provider.MD5;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

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
        User user = new User(1,"张三李四", new MD5().toString());

        Cache<Long, User> cache = Cache1.createCache();
    }
}