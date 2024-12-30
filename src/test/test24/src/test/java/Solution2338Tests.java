import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2338Tests {
    private final Solution2338 solution2338 = new Solution2338();

    @Test
    public void example1() {
        int n = 2;
        int maxValue = 5;
        int expected = 10;
        Assertions.assertEquals(expected, solution2338.idealArrays(n, maxValue));
    }

    @Test
    public void example2() {
        int n = 5;
        int maxValue = 3;
        int expected = 11;
        Assertions.assertEquals(expected, solution2338.idealArrays(n, maxValue));
    }
}