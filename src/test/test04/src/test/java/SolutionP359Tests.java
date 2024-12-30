import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP359Tests {
    @Test
    public void example1() {
        SolutionP359.Logger logger = new SolutionP359.Logger();

        // 返回 true ，下一次 "foo" 可以打印的时间戳是 1 + 10 = 11
        Assertions.assertTrue(logger.shouldPrintMessage(1, "foo"));

        // 返回 true ，下一次 "bar" 可以打印的时间戳是 2 + 10 = 12
        Assertions.assertTrue(logger.shouldPrintMessage(2, "bar"));

        // 3 < 11 ，返回 false
        Assertions.assertFalse(logger.shouldPrintMessage(3, "foo"));

        // 8 < 12 ，返回 false
        Assertions.assertFalse(logger.shouldPrintMessage(8, "bar"));

        // 10 < 11 ，返回 false
        Assertions.assertFalse(logger.shouldPrintMessage(10, "foo"));

        // 11 >= 11 ，返回 true ，下一次 "foo" 可以打印的时间戳是 11 + 10 = 21
        Assertions.assertTrue(logger.shouldPrintMessage(11, "foo"));
    }
}