import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2002Tests {
    private final Solution2002 solution2002 = new Solution2002();

    @Test
    public void example1() {
        String s = "leetcodecom";
        int expected = 9;
        Assertions.assertEquals(expected, solution2002.maxProduct(s));
    }

    @Test
    public void example2() {
        String s = "bb";
        int expected = 1;
        Assertions.assertEquals(expected, solution2002.maxProduct(s));
    }

    @Test
    public void example3() {
        String s = "accbcaxxcxx";
        int expected = 25;
        Assertions.assertEquals(expected, solution2002.maxProduct(s));
    }
}
