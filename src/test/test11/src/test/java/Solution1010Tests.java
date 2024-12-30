import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1010Tests {
    private final Solution1010 solution1010 = new Solution1010();

    @Test
    public void example1() {
        int[] time = {30, 20, 150, 100, 40};
        int expected = 3;
        Assertions.assertEquals(expected, solution1010.numPairsDivisibleBy60(time));
    }

    @Test
    public void example2() {
        int[] time = {60, 60, 60};
        int expected = 3;
        Assertions.assertEquals(expected, solution1010.numPairsDivisibleBy60(time));
    }
}