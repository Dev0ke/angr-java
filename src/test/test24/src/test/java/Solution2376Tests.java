import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2376Tests {
    private final Solution2376 solution2376 = new Solution2376();

    @Test
    public void example1() {
        int n = 20;
        int expected = 19;
        Assertions.assertEquals(expected, solution2376.countSpecialNumbers(n));
    }

    @Test
    public void example2() {
        int n = 5;
        int expected = 5;
        Assertions.assertEquals(expected, solution2376.countSpecialNumbers(n));
    }

    @Test
    public void example3() {
        int n = 135;
        int expected = 110;
        Assertions.assertEquals(expected, solution2376.countSpecialNumbers(n));
    }
}
