import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1481Tests {
    private final Solution1481 solution1481 = new Solution1481();

    @Test
    public void example1() {
        int[] arr = {5, 5, 4};
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution1481.findLeastNumOfUniqueInts(arr, k));
    }

    @Test
    public void example2() {
        int[] arr = {4, 3, 1, 1, 3, 3, 2};
        int k = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution1481.findLeastNumOfUniqueInts(arr, k));
    }
}
