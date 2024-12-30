import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3079Tests {
    private final Solution3079 solution3079 = new Solution3079();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int expected = 6;
        Assertions.assertEquals(expected, solution3079.sumOfEncryptedInt(nums));
    }

    @Test
    public void example2() {
        int[] nums = {10,21,31};
        int expected = 66;
        Assertions.assertEquals(expected, solution3079.sumOfEncryptedInt(nums));
    }
}