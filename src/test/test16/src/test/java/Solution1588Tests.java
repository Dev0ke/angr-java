import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1588Tests {
    private final Solution1588 solution1588 = new Solution1588();

    @Test
    public void example1() {
        int[] arr = {1, 4, 2, 5, 3};
        int expected = 58;
        Assertions.assertEquals(expected, solution1588.sumOddLengthSubarrays(arr));
    }

    @Test
    public void example2() {
        int[] arr = {1, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution1588.sumOddLengthSubarrays(arr));
    }

    @Test
    public void example3() {
        int[] arr = {10, 11, 12};
        int expected = 66;
        Assertions.assertEquals(expected, solution1588.sumOddLengthSubarrays(arr));
    }
}
