import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1848Tests {
    private final Solution1848 solution1848 = new Solution1848();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 5;
        int start = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution1848.getMinDistance(nums, target, start));
    }

    @Test
    public void example2() {
        int[] nums = {1};
        int target = 1;
        int start = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution1848.getMinDistance(nums, target, start));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = 1;
        int start = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution1848.getMinDistance(nums, target, start));
    }
}