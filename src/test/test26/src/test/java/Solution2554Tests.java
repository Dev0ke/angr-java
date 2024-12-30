import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2554Tests {
    private final Solution2554 solution2554 = new Solution2554();

    @Test
    public void example1() {
        int[] banned = {1, 6, 5};
        int n = 5;
        int maxSum = 6;
        int expected = 2;
        Assertions.assertEquals(expected, solution2554.maxCount(banned, n, maxSum));
    }

    @Test
    public void example2() {
        int[] banned = {1, 2, 3, 4, 5, 6, 7};
        int n = 8;
        int maxSum = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution2554.maxCount(banned, n, maxSum));
    }

    @Test
    public void example3() {
        int[] banned = {11};
        int n = 7;
        int maxSum = 50;
        int expected = 7;
        Assertions.assertEquals(expected, solution2554.maxCount(banned, n, maxSum));
    }
}