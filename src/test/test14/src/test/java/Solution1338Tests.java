import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1338Tests {
    private final Solution1338 solution1338 = new Solution1338();

    @Test
    public void example1() {
        int[] arr = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        int expected = 2;
        Assertions.assertEquals(expected, solution1338.minSetSize(arr));
    }

    @Test
    public void example2() {
        int[] arr = {7, 7, 7, 7, 7, 7};
        int expected = 1;
        Assertions.assertEquals(expected, solution1338.minSetSize(arr));
    }

    @Test
    public void example3() {
        int[] arr = {1, 9};
        int expected = 1;
        Assertions.assertEquals(expected, solution1338.minSetSize(arr));
    }

    @Test
    public void example4() {
        int[] arr = {1000, 1000, 3, 7};
        int expected = 1;
        Assertions.assertEquals(expected, solution1338.minSetSize(arr));
    }

    @Test
    public void example5() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int expected = 5;
        Assertions.assertEquals(expected, solution1338.minSetSize(arr));
    }
}
