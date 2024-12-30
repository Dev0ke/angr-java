import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1442Tests {
    private final Solution1442 solution1442 = new Solution1442();

    @Test
    public void example1() {
        int[] arr = {2, 3, 1, 6, 7};
        int expected = 4;
        Assertions.assertEquals(expected, solution1442.countTriplets(arr));
    }

    @Test
    public void example2() {
        int[] arr = {1, 1, 1, 1, 1};
        int expected = 10;
        Assertions.assertEquals(expected, solution1442.countTriplets(arr));
    }

    @Test
    public void example3() {
        int[] arr = {2, 3};
        int expected = 0;
        Assertions.assertEquals(expected, solution1442.countTriplets(arr));
    }

    @Test
    public void example4() {
        int[] arr = {1, 3, 5, 7, 9};
        int expected = 3;
        Assertions.assertEquals(expected, solution1442.countTriplets(arr));
    }

    @Test
    public void example5() {
        int[] arr = {7, 11, 12, 9, 5, 2, 7, 17, 22};
        int expected = 8;
        Assertions.assertEquals(expected, solution1442.countTriplets(arr));
    }
}