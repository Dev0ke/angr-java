import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1343Tests {
    private final Solution1343 solution1343 = new Solution1343();

    @Test
    public void example1() {
        int[] arr = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution1343.numOfSubarrays(arr, k, threshold));
    }

    @Test
    public void example2() {
        int[] arr = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        int k = 3;
        int threshold = 5;
        int expected = 6;
        Assertions.assertEquals(expected, solution1343.numOfSubarrays(arr, k, threshold));
    }
}