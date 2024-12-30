import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2116Tests {
    private final Solution2116 solution2116 = new Solution2116();

    @Test
    public void example1() {
        String s = "))()))";
        String locked = "010100";
        Assertions.assertTrue(solution2116.canBeValid(s, locked));
    }

    @Test
    public void example2() {
        String s = "()()";
        String locked = "0000";
        Assertions.assertTrue(solution2116.canBeValid(s, locked));
    }

    @Test
    public void example3() {
        String s = ")";
        String locked = "0";
        Assertions.assertFalse(solution2116.canBeValid(s, locked));
    }
}
