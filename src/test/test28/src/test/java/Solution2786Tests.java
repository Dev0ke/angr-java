import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2786Tests {
    private final Solution2786 solution2786 = new Solution2786();

    @Test
    public void example1() {
        int[] nums = {2, 3, 6, 1, 9, 2};
        int x = 5;
        long expected = 13;
        Assertions.assertEquals(expected, solution2786.maxScore(nums, x));
    }

    @Test
    public void example2() {
        int[] nums = {2, 4, 6, 8};
        int x = 3;
        long expected = 20;
        Assertions.assertEquals(expected, solution2786.maxScore(nums, x));
    }
}