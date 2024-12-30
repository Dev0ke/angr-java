import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1089Tests {
    private final Solution1089 solution1089 = new Solution1089();

    @Test
    public void example1() {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        int[] expected = {1, 0, 0, 2, 3, 0, 0, 4};
        solution1089.duplicateZeros(arr);
        Assertions.assertArrayEquals(expected, arr);
    }

    @Test
    public void example2() {
        int[] arr = {1, 2, 3};
        int[] expected = {1, 2, 3};
        solution1089.duplicateZeros(arr);
        Assertions.assertArrayEquals(expected, arr);
    }
}