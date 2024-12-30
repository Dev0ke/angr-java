import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution402Tests {
    private final Solution402 solution402 = new Solution402();

    @Test
    public void example1() {
        String nums = "1432219";
        int k = 3;
        String expected = "1219";
        Assertions.assertEquals(expected, solution402.removeKdigits(nums, k));
    }

    @Test
    public void example2() {
        String nums = "10200";
        int k = 1;
        String expected = "200";
        Assertions.assertEquals(expected, solution402.removeKdigits(nums, k));
    }

    @Test
    public void example3() {
        String nums = "10";
        int k = 2;
        String expected = "0";
        Assertions.assertEquals(expected, solution402.removeKdigits(nums, k));
    }
}
