import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3271Tests {
    private final Solution3271 solution3271 = new Solution3271();

    @Test
    public void example1() {
        String s = "abcd";
        int k = 2;
        String expected = "bf";
        Assertions.assertEquals(expected, solution3271.stringHash(s, k));
    }

    @Test
    public void example2() {
        String s = "mxz";
        int k = 3;
        String expected = "i";
        Assertions.assertEquals(expected, solution3271.stringHash(s, k));
    }
}