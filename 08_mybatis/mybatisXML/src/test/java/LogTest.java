import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class LogTest {
    @Test
    void testLogging() {
        log.info("로그 찍힘 확인: {}", "테스트 메시지");
    }
}
