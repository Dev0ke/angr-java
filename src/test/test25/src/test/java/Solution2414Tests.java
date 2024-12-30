import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2414Tests {
    private final Solution2414 solution2414 = new Solution2414();

    @Test
    public void example1() {
        String s = "abacaba";
        int expected = 2;
        Assertions.assertEquals(expected, solution2414.longestContinuousSubstring(s));
    }

    @Test
    public void example2() {
        String s = "abcde";
        int expected = 5;
        Assertions.assertEquals(expected, solution2414.longestContinuousSubstring(s));
    }
}
