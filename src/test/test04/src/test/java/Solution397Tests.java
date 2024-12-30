import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution397Tests {
    private final Solution397 solution397 = new Solution397();

    @Test
    public void example1() {
        int n = 8;
        int expected = 3;
        Assertions.assertEquals(expected, solution397.integerReplacement(n));
    }

    @Test
    public void example2() {
        int n = 7;
        int expected = 4;
        Assertions.assertEquals(expected, solution397.integerReplacement(n));
    }

    @Test
    public void example3() {
        int n = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution397.integerReplacement(n));
    }

    // 补充用例
    @Test
    public void example4() {
        int n = 2147483647;
        int expected = 32;
        Assertions.assertEquals(expected, solution397.integerReplacement(n));
    }
}
