import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2566Tests {
    private final Solution2566 solution2566 = new Solution2566();

    @Test
    public void example1() {
        int num = 11891;
        int expected = 99009;
        Assertions.assertEquals(expected, solution2566.minMaxDifference(num));
    }

    @Test
    public void example2() {
        int num = 90;
        int expected = 99;
        Assertions.assertEquals(expected, solution2566.minMaxDifference(num));
    }
}