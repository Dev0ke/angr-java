import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1122Tests {
    private final Solution1122 solution1122 = new Solution1122();

    @Test
    public void example1() {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] expected = {2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19};
        Assertions.assertArrayEquals(expected, solution1122.relativeSortArray(arr1, arr2));
    }
}
