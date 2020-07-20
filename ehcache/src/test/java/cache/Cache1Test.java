package cache;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.junit.jupiter.api.Test;
import top.zz6628.model.simple.User;

import java.util.Iterator;
import java.util.UUID;

/**
 * @author zhenz
 * @description
 * @date 2020/7/14 13:52
 */
@Slf4j
class Cache1Test {

    @Test
    void test1() {
        CacheManager userCache = Cache1.create();

        Cache<Long, User> onlineCache = userCache.getCache("user", Long.class, User.class);

        for (int i = 1; i < 20; i++) {
            User user = new User(i, i + "" + i, UUID.randomUUID().toString());

            onlineCache.put(user.getId(), user);
        }

        Iterator<Cache.Entry<Long, User>> iterator = onlineCache.iterator();
        while (iterator.hasNext()) {
            Cache.Entry<Long, User> next = iterator.next();
            log.info("{}", JSON.toJSONString(next.getValue()));
        }
    }
}