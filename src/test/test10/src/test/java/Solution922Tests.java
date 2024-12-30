import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution922Tests {
    private final Solution922 solution922 = new Solution922();

    @Test
    public void example1() {
        int[] nums = {4, 2, 5, 7};
        int[] expected = {4, 5, 2, 7};
        Assertions.assertArrayEquals(expected, solution922.sortArrayByParityII(nums));
        Assertions.assertArrayEquals(expected, solution922.sortArrayByParityII2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3};
        int[] expected = {2, 3};
        Assertions.assertArrayEquals(expected, solution922.sortArrayByParityII(nums));
        Assertions.assertArrayEquals(expected, solution922.sortArrayByParityII2(nums));
    }
}