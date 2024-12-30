import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1073Tests {
    private final Solution1073 solution1073 = new Solution1073();

    @Test
    public void example1() {
        int[] arr1 = {1, 1, 1, 1, 1};
        int[] arr2 = {1, 0, 1};
        int[] expected = {1, 0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, solution1073.addNegabinary(arr1, arr2));
    }

    @Test
    public void example2() {
        int[] arr1 = {0};
        int[] arr2 = {0};
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solution1073.addNegabinary(arr1, arr2));
    }

    @Test
    public void example3() {
        int[] arr1 = {0};
        int[] arr2 = {1};
        int[] expected = {1};
        Assertions.assertArrayEquals(expected, solution1073.addNegabinary(arr1, arr2));
    }
}