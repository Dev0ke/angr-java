import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2222Tests {
    private final Solution2222 solution2222 = new Solution2222();

    @Test
    public void example1() {
        String s = "001101";
        long expected = 6;
        Assertions.assertEquals(expected, solution2222.numberOfWays(s));
    }

    @Test
    public void example2() {
        String s = "11100";
        long expected = 0;
        Assertions.assertEquals(expected, solution2222.numberOfWays(s));
    }
}
