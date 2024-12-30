import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1524Tests {
    private final Solution1524 solution1524 = new Solution1524();

    @Test
    public void example1() {
        int[] arr = {1, 3, 5};
        int expected = 4;
        Assertions.assertEquals(expected, solution1524.numOfSubarrays(arr));
    }

    @Test
    public void example2() {
        int[] arr = {2, 4, 6};
        int expected = 0;
        Assertions.assertEquals(expected, solution1524.numOfSubarrays(arr));
    }

    @Test
    public void example3() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int expected = 16;
        Assertions.assertEquals(expected, solution1524.numOfSubarrays(arr));
    }

    @Test
    public void example4() {
        int[] arr = {100, 100, 99, 99};
        int expected = 4;
        Assertions.assertEquals(expected, solution1524.numOfSubarrays(arr));
    }

    @Test
    public void example5() {
        int[] arr = {7};
        int expected = 1;
        Assertions.assertEquals(expected, solution1524.numOfSubarrays(arr));
    }
}