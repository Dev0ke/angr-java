import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1385Tests {
    private final Solution1385 solution1385 = new Solution1385();

    @Test
    public void example1() {
        int[] arr1 = {4, 5, 8};
        int[] arr2 = {10, 9, 1, 8};
        int d = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution1385.findTheDistanceValue(arr1, arr2, d));
    }

    @Test
    public void example2() {
        int[] arr1 = {1, 4, 2, 3};
        int[] arr2 = {-4, -3, 6, 10, 20, 30};
        int d = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution1385.findTheDistanceValue(arr1, arr2, d));
    }

    @Test
    public void example3() {
        int[] arr1 = {2, 1, 100, 3};
        int[] arr2 = {-5, -2, 10, -3, 7};
        int d = 6;
        int expected = 1;
        Assertions.assertEquals(expected, solution1385.findTheDistanceValue(arr1, arr2, d));
    }
}
