import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1562Tests {
    private final Solution1562 solution1562 = new Solution1562();

    @Test
    public void example1() {
        int[] arr = {3, 5, 1, 2, 4};
        int m = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution1562.findLatestStep(arr, m));
    }

    @Test
    public void example2() {
        int[] arr = {3, 1, 5, 4, 2};
        int m = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solution1562.findLatestStep(arr, m));
    }

    @Test
    public void example3() {
        int[] arr = {1};
        int m = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution1562.findLatestStep(arr, m));
    }

    @Test
    public void example4() {
        int[] arr = {2, 1};
        int m = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution1562.findLatestStep(arr, m));
    }
}