import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution796Tests {
    private final Solution796 solution796 = new Solution796();

    @Test
    public void example1() {
        String s = "abcde";
        String goal = "cdeab";
        Assertions.assertTrue(solution796.rotateString(s, goal));
    }

    @Test
    public void example2() {
        String s = "abcde";
        String goal = "abced";
        Assertions.assertFalse(solution796.rotateString(s, goal));
    }
}
