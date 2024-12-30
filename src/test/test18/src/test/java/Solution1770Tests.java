import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1770Tests {
    private final Solution1770 solution1770 = new Solution1770();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int[] multipliers = {3, 2, 1};
        int expected = 14;
        Assertions.assertEquals(expected, solution1770.maximumScore(nums, multipliers));
    }

    @Test
    public void example2() {
        int[] nums = {-5, -3, -3, -2, 7, 1};
        int[] multipliers = {-10, -5, 3, 4, 6};
        int expected = 102;
        Assertions.assertEquals(expected, solution1770.maximumScore(nums, multipliers));
    }
}