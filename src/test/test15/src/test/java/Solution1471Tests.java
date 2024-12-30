import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1471Tests {
    private final Solution1471 solution1471 = new Solution1471();

    @Test
    public void example1() {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
        int[] expected = {5, 1};
        Assertions.assertArrayEquals(expected, solution1471.getStrongest(arr, k));
    }

    @Test
    public void example2() {
        int[] arr = {1, 1, 3, 5, 5};
        int k = 2;
        int[] expected = {5, 5};
        Assertions.assertArrayEquals(expected, solution1471.getStrongest(arr, k));
    }

    @Test
    public void example3() {
        int[] arr = {6, 7, 11, 7, 6, 8};
        int k = 5;
        int[] expected = {11, 8, 6, 6, 7};
        Assertions.assertArrayEquals(expected, solution1471.getStrongest(arr, k));
    }

    @Test
    public void example4() {
        int[] arr = {6, -3, 7, 2, 11};
        int k = 3;
        int[] expected = {-3, 11, 2};
        Assertions.assertArrayEquals(expected, solution1471.getStrongest(arr, k));
    }

    @Test
    public void example5() {
        int[] arr = {-7, 22, 17, 3};
        int k = 2;
        int[] expected = {22, 17};
        Assertions.assertArrayEquals(expected, solution1471.getStrongest(arr, k));
    }
}