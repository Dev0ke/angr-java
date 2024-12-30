import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1785Tests {
    private final Solution1785 solution1785 = new Solution1785();

    @Test
    public void example1() {
        int[] nums = {1, -1, 1};
        int limit = 3;
        int goal = -4;
        int expected = 2;
        Assertions.assertEquals(expected, solution1785.minElements(nums, limit, goal));
    }

    @Test
    public void example2() {
        int[] nums = {1, -10, 9, 1};
        int limit = 100;
        int goal = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solution1785.minElements(nums, limit, goal));
    }
}