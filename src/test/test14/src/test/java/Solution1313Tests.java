import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1313Tests {
    private final Solution1313 solution1313 = new Solution1313();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {2, 4, 4, 4};
        Assertions.assertArrayEquals(expected, solution1313.decompressRLElist(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 2, 3};
        int[] expected = {1, 3, 3};
        Assertions.assertArrayEquals(expected, solution1313.decompressRLElist(nums));
    }
}