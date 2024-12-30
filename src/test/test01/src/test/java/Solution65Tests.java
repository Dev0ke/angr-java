import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution65Tests {
    private final Solution65 solution65 = new Solution65();

    @Test
    public void example1() {
        String s = "0";
        Assertions.assertTrue(solution65.isNumber(s));
    }

    @Test
    public void example2() {
        String s = "e";
        Assertions.assertFalse(solution65.isNumber(s));
    }

    @Test
    public void example3() {
        String s = ".";
        Assertions.assertFalse(solution65.isNumber(s));
    }
}
