import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1191Tests {
    private final Solution1191 solution1191 = new Solution1191();

    @Test
    public void example1() {
        int[] arr = {1, 2};
        int k = 3;
        int expected = 9;
        Assertions.assertEquals(expected, solution1191.kConcatenationMaxSum(arr, k));
    }

    @Test
    public void example2() {
        int[] arr = {1, -2, 1};
        int k = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution1191.kConcatenationMaxSum(arr, k));
    }

    @Test
    public void example3() {
        int[] arr = {-1, -2};
        int k = 7;
        int expected = 0;
        Assertions.assertEquals(expected, solution1191.kConcatenationMaxSum(arr, k));
    }
}