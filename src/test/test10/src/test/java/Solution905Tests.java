import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution905Tests {
    private final Solution905 solution905 = new Solution905();

    @Test
    public void example1() {
        int[] nums = {3, 1, 2, 4};
        // 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
        int[] expected = {2, 4, 3, 1};
//        int[] expected = {4, 2, 1, 3};
        Assertions.assertArrayEquals(expected, solution905.sortArrayByParity(nums));
    }

    @Test
    public void example1_1() {
        int[] nums = {3, 1, 2, 4};
        // 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
//        int[] expected = {2, 4, 3, 1};
        int[] expected = {4, 2, 1, 3};
        Assertions.assertArrayEquals(expected, solution905.sortArrayByParity2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0};
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solution905.sortArrayByParity(nums));
    }

    @Test
    public void example2_2() {
        int[] nums = {0};
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solution905.sortArrayByParity2(nums));
    }
}
