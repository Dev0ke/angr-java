import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3234Tests {
    private final Solution3234 solution3234 = new Solution3234();

    @Test
    public void example1() {
        String s = "00011";
        int expected = 5;
        Assertions.assertEquals(expected, solution3234.numberOfSubstrings(s));
    }

    @Test
    public void example2() {
        String s = "101101";
        int expected = 16;
        Assertions.assertEquals(expected, solution3234.numberOfSubstrings(s));
    }
}