import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution888Tests {
    private final Solution888 solution888 = new Solution888();

    @Test
    public void example1() {
        int[] aliceSizes = {1, 1};
        int[] bobSizes = {2, 2};
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solution888.fairCandySwap(aliceSizes, bobSizes));
    }

    @Test
    public void example2() {
        int[] aliceSizes = {1, 2};
        int[] bobSizes = {2, 3};
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solution888.fairCandySwap(aliceSizes, bobSizes));
    }

    @Test
    public void example3() {
        int[] aliceSizes = {2};
        int[] bobSizes = {1, 3};
        int[] expected = {2, 3};
        Assertions.assertArrayEquals(expected, solution888.fairCandySwap(aliceSizes, bobSizes));
    }

    @Test
    public void example4() {
        int[] aliceSizes = {1, 2, 5};
        int[] bobSizes = {2, 4};
        int[] expected = {5, 4};
        Assertions.assertArrayEquals(expected, solution888.fairCandySwap(aliceSizes, bobSizes));
    }
}
