import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3043Tests {
    private final Solution3043 solution3043 = new Solution3043();

    @Test
    public void example1() {
        int[] arr1 = {1, 10, 100};
        int[] arr2 = {1000};
        int expected = 3;
        Assertions.assertEquals(expected, solution3043.longestCommonPrefix(arr1, arr2));
    }

    @Test
    public void example2() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 4, 4};
        int expected = 0;
        Assertions.assertEquals(expected, solution3043.longestCommonPrefix(arr1, arr2));
    }
}