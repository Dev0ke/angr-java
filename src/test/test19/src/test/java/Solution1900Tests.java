import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1900Tests {
    private final Solution1900 solution1900 = new Solution1900();

    @Test
    public void example1() {
        int n = 11;
        int firstPlayer = 2;
        int secondPlayer = 4;
        int[] expected = {3, 4};
        Assertions.assertArrayEquals(expected, solution1900.earliestAndLatest(n, firstPlayer, secondPlayer));
    }

    @Test
    public void example2() {
        int n = 5;
        int firstPlayer = 1;
        int secondPlayer = 5;
        int[] expected = {1, 1};
        Assertions.assertArrayEquals(expected, solution1900.earliestAndLatest(n, firstPlayer, secondPlayer));
    }
}