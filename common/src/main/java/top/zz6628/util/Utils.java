package top.zz6628.util;

import lombok.extern.slf4j.Slf4j;
import top.zz6628.model.simple.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @author zhenz
 * @description
 * @date 2020/7/10 20:05
 */
@Slf4j
public class Utils {

    public static String md5(String text) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    text.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        StringBuilder md5code = new StringBuilder(new BigInteger(1, secretBytes).toString(16));
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code.insert(0, "0");
        }
        return md5code.toString();
    }

    /**
     * 创建用户
     *
     * @param id 用户id
     * @return
     */
    public static User createUser(Long id) {
        return createUser(id, 0);
    }

    /**
     * 创建用户
     *
     * @param id    用户id
     * @param sleep 休眠
     * @return
     */
    public static User createUser(Long id, long sleep) {
        if (sleep > 0) {
            try {
                Thread.sleep(sleep);
                log.info("createUser id:{} sleep:{}", id, sleep);
            } catch (InterruptedException ignored) {
            }
        }
        return new User(id, "test" + id, UUID.randomUUID().toString());
    }
}
