import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution981Tests {
    @Test
    public void example1() {
        // 存储键 "foo" 和值 "bar" ，时间戳 timestamp = 1
        Solution981.TimeMap timeMap = new Solution981.TimeMap();
        timeMap.set("foo", "bar", 1);

        // 返回 "bar"
        Assertions.assertEquals("bar", timeMap.get("foo", 1));

        // 返回 "bar", 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"） 。
        Assertions.assertEquals("bar", timeMap.get("foo", 3));

        // 存储键 "foo" 和值 "bar2" ，时间戳 timestamp = 4
        timeMap.set("foo", "bar2", 4);

        // 返回 "bar2"
        Assertions.assertEquals("bar2", timeMap.get("foo", 4));

        // 返回 "bar2"
        Assertions.assertEquals("bar2", timeMap.get("foo", 5));
    }
}
