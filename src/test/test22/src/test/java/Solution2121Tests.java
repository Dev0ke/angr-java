import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2121Tests {
    private final Solution2121 solution2121 = new Solution2121();

    @Test
    public void example1() {
        int[] arr = {2, 1, 3, 1, 2, 3, 3};
        long[] expected = {4, 2, 7, 2, 4, 4, 5};
        Assertions.assertArrayEquals(expected, solution2121.getDistances(arr));
        Assertions.assertArrayEquals(expected, solution2121.getDistances2(arr));
    }

    @Test
    public void example2() {
        int[] arr = {10, 5, 10, 10};
        long[] expected = {5, 0, 3, 4};
        Assertions.assertArrayEquals(expected, solution2121.getDistances(arr));
        Assertions.assertArrayEquals(expected, solution2121.getDistances2(arr));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] arr = UtUtils.loadingInts("solution2121-example3-input.txt", 0);
        long[] expected = UtUtils.loadingLongs("solution2121-example3-output.txt", 0);
        Assertions.assertArrayEquals(expected, solution2121.getDistances(arr));
//        Assertions.assertArrayEquals(expected, solution2121.getDistances2(arr));
    }
}
