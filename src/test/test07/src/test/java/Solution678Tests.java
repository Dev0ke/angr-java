import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution678Tests {
    private final Solution678 solution678 = new Solution678();

    @Test
    public void example1() {
        String s = "()";
        Assertions.assertTrue(solution678.checkValidString(s));
    }

    @Test
    public void example2() {
        String s = "(*)";
        Assertions.assertTrue(solution678.checkValidString(s));
    }

    @Test
    public void example3() {
        String s = "(*))";
        Assertions.assertTrue(solution678.checkValidString(s));
    }
}
