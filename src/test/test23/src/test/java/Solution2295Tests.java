import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2295Tests {
    private final Solution2295 solution2295 = new Solution2295();

    @Test
    public void example1() {
        int[] nums = {1, 2, 4, 6};
        int[][] operations = UtUtils.stringToInts2("[[1,3],[4,7],[6,1]]");
        int[] expected = {3, 2, 7, 1};
        Assertions.assertArrayEquals(expected, solution2295.arrayChange(nums, operations));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2};
        int[][] operations = UtUtils.stringToInts2("[[1,3],[2,1],[3,2]]");
        int[] expected = {2, 1};
        Assertions.assertArrayEquals(expected, solution2295.arrayChange(nums, operations));
    }
}
