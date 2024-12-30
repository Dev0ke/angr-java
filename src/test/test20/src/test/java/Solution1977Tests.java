import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1977Tests {
    private final Solution1977 solution1977 = new Solution1977();

    @Test
    public void example1() {
        String num = "327";
        int expected = 2;
        Assertions.assertEquals(expected, solution1977.numberOfCombinations(num));
    }

    @Test
    public void example2() {
        String num = "094";
        int expected = 0;
        Assertions.assertEquals(expected, solution1977.numberOfCombinations(num));
    }

    @Test
    public void example3() {
        String num = "0";
        int expected = 0;
        Assertions.assertEquals(expected, solution1977.numberOfCombinations(num));
    }

    @Test
    public void example4() {
        String num = "9999999999999";
        int expected = 101;
        Assertions.assertEquals(expected, solution1977.numberOfCombinations(num));
    }
}
