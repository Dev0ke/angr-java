import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1835Tests {
    private final Solution1835 solution1835 = new Solution1835();

    @Test
    public void example1() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {6, 5};
        int expected = 0;
        Assertions.assertEquals(expected, solution1835.getXORSum(arr1, arr2));
    }

    @Test
    public void example2() {
        int[] arr1 = {12};
        int[] arr2 = {4};
        int expected = 4;
        Assertions.assertEquals(expected, solution1835.getXORSum(arr1, arr2));
    }
}