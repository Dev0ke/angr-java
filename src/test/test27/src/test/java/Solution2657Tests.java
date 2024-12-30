import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2657Tests {
    private final Solution2657 solution2657 = new Solution2657();

    @Test
    public void example1() {
        int[] A = {1, 3, 2, 4};
        int[] B = {3, 1, 2, 4};
        int[] expected = {0, 2, 3, 4};
        Assertions.assertArrayEquals(expected, solution2657.findThePrefixCommonArray(A, B));
    }

    @Test
    public void example2() {
        int[] A = {2, 3, 1};
        int[] B = {3, 1, 2};
        int[] expected = {0, 1, 3};
        Assertions.assertArrayEquals(expected, solution2657.findThePrefixCommonArray(A, B));
    }
}