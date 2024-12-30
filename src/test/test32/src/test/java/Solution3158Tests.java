import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3158Tests {
    private final Solution3158 solution3158 = new Solution3158();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1, 3};
        int expected = 1;
        Assertions.assertEquals(expected, solution3158.duplicateNumbersXOR(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3};
        int expected = 0;
        Assertions.assertEquals(expected, solution3158.duplicateNumbersXOR(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 2, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution3158.duplicateNumbersXOR(nums));
    }
}