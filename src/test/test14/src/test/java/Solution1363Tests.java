import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1363Tests {
    private final Solution1363 solution1363 = new Solution1363();

    @Test
    public void example1() {
        int[] digits = {8, 1, 9};
        String expected = "981";
        Assertions.assertEquals(expected, solution1363.largestMultipleOfThree(digits));
    }

    @Test
    public void example2() {
        int[] digits = {8, 6, 7, 1, 0};
        String expected = "8760";
        Assertions.assertEquals(expected, solution1363.largestMultipleOfThree(digits));
    }

    @Test
    public void example3() {
        int[] digits = {1};
        String expected = "";
        Assertions.assertEquals(expected, solution1363.largestMultipleOfThree(digits));
    }

    @Test
    public void example4() {
        int[] digits = {0, 0, 0, 0, 0, 0};
        String expected = "0";
        Assertions.assertEquals(expected, solution1363.largestMultipleOfThree(digits));
    }
}