import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1356Tests {
    private final Solution1356 solution1356 = new Solution1356();

    @Test
    public void example1() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = {0, 1, 2, 4, 8, 3, 5, 6, 7};
        Assertions.assertArrayEquals(expected, solution1356.sortByBits(arr));
    }

    @Test
    public void example2() {
        int[] arr = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        int[] expected = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
        Assertions.assertArrayEquals(expected, solution1356.sortByBits(arr));
    }

    @Test
    public void example3() {
        int[] arr = {10000, 10000};
        int[] expected = {10000, 10000};
        Assertions.assertArrayEquals(expected, solution1356.sortByBits(arr));
    }

    @Test
    public void example4() {
        int[] arr = {2, 3, 5, 7, 11, 13, 17, 19};
        int[] expected = {2, 3, 5, 17, 7, 11, 13, 19};
        Assertions.assertArrayEquals(expected, solution1356.sortByBits(arr));
    }

    @Test
    public void example5() {
        int[] arr = {10, 100, 1000, 10000};
        int[] expected = {10, 100, 10000, 1000};
        Assertions.assertArrayEquals(expected, solution1356.sortByBits(arr));
    }
}
