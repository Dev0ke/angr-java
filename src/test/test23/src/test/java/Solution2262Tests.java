import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2262Tests {
    private final Solution2262 solution2262 = new Solution2262();

    @Test
    public void example1() {
        String s = "abbca";
        long expected = 28;
        Assertions.assertEquals(expected, solution2262.appealSum(s));
    }

    @Test
    public void example2() {
        String s = "code";
        long expected = 20;
        Assertions.assertEquals(expected, solution2262.appealSum(s));
    }
}
