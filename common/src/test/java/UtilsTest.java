import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import top.zz6628.util.Utils;

/**
 * @author zhenz
 * @description
 * @date 2020/7/10 20:07
 */
@Slf4j
class UtilsTest {

    @Test
    void md5() {
        log.info(Utils.md5("123456"));
    }
}