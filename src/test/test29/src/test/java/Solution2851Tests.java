import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2851Tests {
    private final Solution2851 solution2851 = new Solution2851();

    @Test
    public void example1() {
        String s = "abcd";
        String t = "cdab";
        long k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution2851.numberOfWays(s, t, k));
    }

    @Test
    public void example2() {
        String s = "ababab";
        String t = "ababab";
        long k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution2851.numberOfWays(s, t, k));
    }
}