import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2167Tests {
    private final Solution2167 solution2167 = new Solution2167();

    @Test
    public void example1() {
        String s = "1100101";
        int expected = 5;
        Assertions.assertEquals(expected, solution2167.minimumTime(s));
    }

    @Test
    public void example2() {
        String s = "0010";
        int expected = 2;
        Assertions.assertEquals(expected, solution2167.minimumTime(s));
    }
}
