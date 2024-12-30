import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution66Tests {
    private final Solution66 solution66 = new Solution66();

    @Test
    public void example1() {
        int[] digits = {1, 2, 3};
        int[] expected = {1, 2, 4};
        Assertions.assertArrayEquals(expected, solution66.plusOne(digits));
    }

    @Test
    public void example2() {
        int[] digits = {4, 3, 2, 1};
        int[] expected = {4, 3, 2, 2};
        Assertions.assertArrayEquals(expected, solution66.plusOne(digits));
    }

    @Test
    public void example3() {
        int[] digits = {0};
        int[] expected = {1};
        Assertions.assertArrayEquals(expected, solution66.plusOne(digits));
    }
}
