import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution696Tests {
    private final Solution696 solution696 = new Solution696();

    @Test
    public void example1() {
        String s = "00110011";
        int expected = 6;
        Assertions.assertEquals(expected, solution696.countBinarySubstrings(s));
    }

    @Test
    public void example2() {
        String s = "10101";
        int expected = 4;
        Assertions.assertEquals(expected, solution696.countBinarySubstrings(s));
    }
}
