import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1574Tests {
    private final Solution1574 solution1574 = new Solution1574();

    @Test
    public void example1() {
        int[] arr = {1, 2, 3, 10, 4, 2, 3, 5};
        int expected = 3;
        Assertions.assertEquals(expected, solution1574.findLengthOfShortestSubarray(arr));
    }

    @Test
    public void example2() {
        int[] arr = {5, 4, 3, 2, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solution1574.findLengthOfShortestSubarray(arr));
    }

    @Test
    public void example3() {
        int[] arr = {1, 2, 3};
        int expected = 0;
        Assertions.assertEquals(expected, solution1574.findLengthOfShortestSubarray(arr));
    }

    @Test
    public void example4() {
        int[] arr = {1};
        int expected = 0;
        Assertions.assertEquals(expected, solution1574.findLengthOfShortestSubarray(arr));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/315650829/
        // 去掉左侧
        int[] arr = {16, 10, 0, 3, 22, 1, 14, 7, 1, 12, 15};
        int expected = 8;
        Assertions.assertEquals(expected, solution1574.findLengthOfShortestSubarray(arr));
    }

    @Test
    public void example6() {
        // https://leetcode.cn/submissions/detail/315666406/
        int[] arr = UtUtils.loadingInts("solution1574-example6-input.txt", 0);
        int expected = 33323;
        Assertions.assertEquals(expected, solution1574.findLengthOfShortestSubarray(arr));
    }
}
