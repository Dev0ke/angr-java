import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution786Tests {
    private final Solution786 solution786 = new Solution786();

    @Test
    public void example1() {
        int[] arr = {1, 2, 3, 5};
        int k = 3;
        int[] expected = {2, 5};
        Assertions.assertArrayEquals(expected, solution786.kthSmallestPrimeFraction(arr, k));
    }

    @Test
    public void example2() {
        int[] arr = {1, 7};
        int k = 1;
        int[] expected = {1, 7};
        Assertions.assertArrayEquals(expected, solution786.kthSmallestPrimeFraction(arr, k));
    }
}
