import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3233Tests {
    private final Solution3233 solution3233 = new Solution3233();

    @Test
    public void example1() {
        int l = 5;
        int r = 7;
        int expected = 3;
        Assertions.assertEquals(expected, solution3233.nonSpecialCount(l, r));
    }

    @Test
    public void example2() {
        int l = 4;
        int r = 16;
        int expected = 11;
        Assertions.assertEquals(expected, solution3233.nonSpecialCount(l, r));
    }
}