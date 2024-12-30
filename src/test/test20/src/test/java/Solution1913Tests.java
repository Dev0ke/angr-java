import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1913Tests {
    private final Solution1913 solution1913 = new Solution1913();

    @Test
    public void example1() {
        int[] nums = {5, 6, 2, 7, 4};
        int expected = 34;
        Assertions.assertEquals(expected, solution1913.maxProductDifference(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 2, 5, 9, 7, 4, 8};
        int expected = 64;
        Assertions.assertEquals(expected, solution1913.maxProductDifference(nums));
    }
}
