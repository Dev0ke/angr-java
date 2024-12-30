import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution553Tests {
    private final Solution553 solution553 = new Solution553();

    @Test
    public void example1() {
        int[] nums = {1000, 100, 10, 2};
        String expected = "1000/(100/10/2)";
        Assertions.assertEquals(expected, solution553.optimalDivision(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 4};
        String expected = "2/(3/4)";
        Assertions.assertEquals(expected, solution553.optimalDivision(nums));
    }
}