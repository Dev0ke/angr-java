import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2433Tests {
    private final Solution2433 solution2433 = new Solution2433();

    @Test
    public void example1() {
        int[] pref = {5, 2, 0, 3, 1};
        int[] expected = {5, 7, 2, 3, 2};
        Assertions.assertArrayEquals(expected, solution2433.findArray(pref));
    }

    @Test
    public void example2() {
        int[] pref = {13};
        int[] expected = {13};
        Assertions.assertArrayEquals(expected, solution2433.findArray(pref));
    }
}
