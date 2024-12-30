import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1963Tests {
    private final Solution1963 solution1963 = new Solution1963();

    @Test
    public void example1() {
        String s = "][][";
        int expected = 1;
        Assertions.assertEquals(expected, solution1963.minSwaps(s));
    }

    @Test
    public void example2() {
        String s = "]]][[[";
        int expected = 2;
        Assertions.assertEquals(expected, solution1963.minSwaps(s));
    }

    @Test
    public void example3() {
        String s = "[]";
        int expected = 0;
        Assertions.assertEquals(expected, solution1963.minSwaps(s));
    }
}
