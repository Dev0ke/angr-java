import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1984Tests {
    private final Solution1984 solution1984 = new Solution1984();

    @Test
    public void example1() {
        int[] nums = {90};
        int k = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution1984.minimumDifference(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {9, 4, 1, 7};
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution1984.minimumDifference(nums, k));
    }
}
