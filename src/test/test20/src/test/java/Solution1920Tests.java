import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1920Tests {
    private final Solution1920 solution1920 = new Solution1920();

    @Test
    public void example1() {
        int[] nums = {0, 2, 1, 5, 3, 4};
        int[] expected = {0, 1, 2, 4, 5, 3};
        Assertions.assertArrayEquals(expected, solution1920.buildArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 0, 1, 2, 3, 4};
        int[] expected = {4, 5, 0, 1, 2, 3};
        Assertions.assertArrayEquals(expected, solution1920.buildArray(nums));
    }
}
