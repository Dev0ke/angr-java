import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2027Tests {
    private final Solution2027 solution2027 = new Solution2027();

    @Test
    public void example1() {
        String s = "XXX";
        int expected = 1;
        Assertions.assertEquals(expected, solution2027.minimumMoves(s));
    }

    @Test
    public void example2() {
        String s = "XXOX";
        int expected = 2;
        Assertions.assertEquals(expected, solution2027.minimumMoves(s));
    }

    @Test
    public void example3() {
        String s = "OOOO";
        int expected = 0;
        Assertions.assertEquals(expected, solution2027.minimumMoves(s));
    }
}
