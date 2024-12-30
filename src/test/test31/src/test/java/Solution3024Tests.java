import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3024Tests {
    private final Solution3024 solution3024 = new Solution3024();

    @Test
    public void example1() {
        int[] nums = {3, 3, 3};
        String expected = "equilateral";
        Assertions.assertEquals(expected, solution3024.triangleType(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 4, 5};
        String expected = "scalene";
        Assertions.assertEquals(expected, solution3024.triangleType(nums));
    }
}