import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2177Tests {
    private final Solution2177 solution2177 = new Solution2177();

    @Test
    public void example1() {
        long num = 33;
        long[] expected = {10, 11, 12};
        Assertions.assertArrayEquals(expected, solution2177.sumOfThree(num));
    }

    @Test
    public void example2() {
        long num = 4;
        long[] expected = {};
        Assertions.assertArrayEquals(expected, solution2177.sumOfThree(num));
    }
}
