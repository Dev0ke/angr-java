import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2607Tests {
    private final Solution2607 solution2607 = new Solution2607();

    @Test
    public void example1() {
        int[] arr = {1, 4, 1, 3};
        int k = 2;
        long expected = 1;
        Assertions.assertEquals(expected, solution2607.makeSubKSumEqual(arr, k));
    }

    @Test
    public void example2() {
        int[] arr = {2, 5, 5, 7};
        int k = 3;
        long expected = 5;
        Assertions.assertEquals(expected, solution2607.makeSubKSumEqual(arr, k));
    }
}