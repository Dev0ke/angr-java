import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1374Tests {
    private final Solution1374 solution1374 = new Solution1374();

    @Test
    public void example1() {
        int n = 4;
        String expected = "pppz";
        // 答案不唯一
//        Assertions.assertEquals(expected, solution1374.generateTheString(n));
    }

    @Test
    public void example2() {
        int n = 2;
        String expected = "xy";
//        Assertions.assertEquals(expected, solution1374.generateTheString(n));
    }

    @Test
    public void example3() {
        int n = 7;
        String expected = "holasss";
//        Assertions.assertEquals(expected, solution1374.generateTheString(n));
    }
}
