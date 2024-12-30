import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3086Tests {
    private final Solution3086 solution3086 = new Solution3086();

    @Test
    public void example1() {
        int[] nums = {1, 1, 0, 0, 0, 1, 1, 0, 0, 1};
        int k = 3;
        int maxChanges = 1;
        long expected = 3;
        Assertions.assertEquals(expected, solution3086.minimumMoves(nums, k, maxChanges));
    }

    @Test
    public void example2() {
        int[] nums = {0, 0, 0, 0};
        int k = 2;
        int maxChanges = 3;
        long expected = 4;
        Assertions.assertEquals(expected, solution3086.minimumMoves(nums, k, maxChanges));
    }
}