import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution907Tests {
    private final Solution907 solution907 = new Solution907();

    @Test
    public void example1() {
        int[] arr = {3, 1, 2, 4};
        int expected = 17;
        Assertions.assertEquals(expected, solution907.sumSubarrayMins(arr));
    }

    @Test
    public void example2() {
        int[] arr = {11, 81, 94, 43, 3};
        int expected = 444;
        Assertions.assertEquals(expected, solution907.sumSubarrayMins(arr));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/319474532/
        // 73 / 87 个通过测试用例（溢出）
        int[] arr = UtUtils.loadingInts("solution907-example3-input.txt", 0);
        int expected = 508796209;
        Assertions.assertEquals(expected, solution907.sumSubarrayMins(arr));
    }
}
