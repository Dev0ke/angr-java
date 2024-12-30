import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1186Tests {
    private final Solution1186 solution1186 = new Solution1186();

    @Test
    public void example1() {
        int[] arr = {1, -2, 0, 3};
        int expected = 4;
        Assertions.assertEquals(expected, solution1186.maximumSum(arr));
    }

    @Test
    public void example2() {
        int[] arr = {1, -2, -2, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution1186.maximumSum(arr));
    }

    @Test
    public void example3() {
        int[] arr = {-1, -1, -1, -1};
        int expected = -1;
        Assertions.assertEquals(expected, solution1186.maximumSum(arr));
    }
}