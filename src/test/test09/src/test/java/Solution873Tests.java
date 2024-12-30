import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution873Tests {
    private final Solution873 solution873 = new Solution873();

    @Test
    public void example1() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int expected = 5;
        Assertions.assertEquals(expected, solution873.lenLongestFibSubseq(arr));
    }

    @Test
    public void example2() {
        int[] arr = {1, 3, 7, 11, 12, 14, 18};
        int expected = 3;
        Assertions.assertEquals(expected, solution873.lenLongestFibSubseq(arr));
    }
}
