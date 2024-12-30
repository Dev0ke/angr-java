import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2966Tests {
    private final Solution2966 solution2966 = new Solution2966();

    @Test
    public void example1() {
        int[] nums = {1, 3, 4, 8, 7, 9, 3, 5, 1};
        int k = 2;
        int[][] expected = UtUtils.stringToInts2("[[1,1,3],[3,4,5],[7,8,9]]");
        Assertions.assertArrayEquals(expected, solution2966.divideArray(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 3, 2, 7, 3};
        int k = 3;
        int[][] expected = UtUtils.stringToInts2("[]");
        Assertions.assertArrayEquals(expected, solution2966.divideArray(nums, k));
    }
}