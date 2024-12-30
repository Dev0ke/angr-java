import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2165Tests {
    private final Solution2165 solution2165 = new Solution2165();

    @Test
    public void example1() {
        long num = 310L;
        long expected = 103L;
        Assertions.assertEquals(expected, solution2165.smallestNumber(num));
    }

    @Test
    public void example2() {
        long num = -7605L;
        long expected = -7650L;
        Assertions.assertEquals(expected, solution2165.smallestNumber(num));
    }

    // 补充用例
    @Test
    public void example3() {
        long num = 0L;
        long expected = 0L;
        Assertions.assertEquals(expected, solution2165.smallestNumber(num));
    }
}
