import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1187Tests {
    private final Solution1187 solution1187 = new Solution1187();

    @Test
    public void example1() {
        int[] arr1 = {1, 5, 3, 6, 7};
        int[] arr2 = {1, 3, 2, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solution1187.makeArrayIncreasing(arr1, arr2));
    }

    @Test
    public void example2() {
        int[] arr1 = {1, 5, 3, 6, 7};
        int[] arr2 = {4, 3, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution1187.makeArrayIncreasing(arr1, arr2));
    }

    @Test
    public void example3() {
        int[] arr1 = {1, 5, 3, 6, 7};
        int[] arr2 = {1, 6, 3, 3};
        int expected = -1;
        Assertions.assertEquals(expected, solution1187.makeArrayIncreasing(arr1, arr2));
    }
}