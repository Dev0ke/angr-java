import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3015Tests {
    private final Solution3015 solution3015 = new Solution3015();

    @Test
    public void example1() {
        int n = 3;
        int x = 1;
        int y = 3;
        int[] expected = {6, 0, 0};
        Assertions.assertArrayEquals(expected, solution3015.countOfPairs(n, x, y));
        Assertions.assertArrayEquals(expected, solution3015.countOfPairs2(n, x, y));
    }

    @Test
    public void example2() {
        int n = 5;
        int x = 2;
        int y = 4;
        int[] expected = {10, 8, 2, 0, 0};
        Assertions.assertArrayEquals(expected, solution3015.countOfPairs(n, x, y));
        Assertions.assertArrayEquals(expected, solution3015.countOfPairs2(n, x, y));
    }

    @Test
    public void example3() {
        int n = 4;
        int x = 1;
        int y = 1;
        int[] expected = {6, 4, 2, 0};
        Assertions.assertArrayEquals(expected, solution3015.countOfPairs(n, x, y));
        Assertions.assertArrayEquals(expected, solution3015.countOfPairs2(n, x, y));
    }
}