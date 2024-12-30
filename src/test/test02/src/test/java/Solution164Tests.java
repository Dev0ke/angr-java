import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution164Tests {
    private final Solution164 solution164 = new Solution164();

    @Test
    public void example1() {
        int[] nums = {3, 6, 9, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution164.maximumGap(nums));
        Assertions.assertEquals(expected, solution164.maximumGap2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {10};
        int expected = 0;
        Assertions.assertEquals(expected, solution164.maximumGap(nums));
        Assertions.assertEquals(expected, solution164.maximumGap2(nums));
    }
}