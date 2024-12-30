import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3098Tests {
    private final Solution3098 solution3098 = new Solution3098();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int k = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution3098.sumOfPowers(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2};
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution3098.sumOfPowers(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {4, 3, -1};
        int k = 2;
        int expected = 10;
        Assertions.assertEquals(expected, solution3098.sumOfPowers(nums, k));
    }
}