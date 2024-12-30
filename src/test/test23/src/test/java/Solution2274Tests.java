import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2274Tests {
    private final Solution2274 solution2274 = new Solution2274();

    @Test
    public void example1() {
        int bottom = 2;
        int top = 9;
        int[] special = {4, 6};
        int expected = 3;
        Assertions.assertEquals(expected, solution2274.maxConsecutive(bottom, top, special));
    }

    @Test
    public void example2() {
        int bottom = 6;
        int top = 8;
        int[] special = {7, 6, 8};
        int expected = 0;
        Assertions.assertEquals(expected, solution2274.maxConsecutive(bottom, top, special));
    }
}
