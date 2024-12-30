import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1250Tests {
    private final Solution1250 solution1250 = new Solution1250();

    @Test
    public void example1() {
        int[] nums = {12, 5, 7, 23};
        Assertions.assertTrue(solution1250.isGoodArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {29, 6, 10};
        Assertions.assertTrue(solution1250.isGoodArray(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, 6};
        Assertions.assertFalse(solution1250.isGoodArray(nums));
    }
}