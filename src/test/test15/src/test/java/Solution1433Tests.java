import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1433Tests {
    private final Solution1433 solution1433 = new Solution1433();

    @Test
    public void example1() {
        String s1 = "abc";
        String s2 = "xya";
        Assertions.assertTrue(solution1433.checkIfCanBreak(s1, s2));
    }

    @Test
    public void example2() {
        String s1 = "abe";
        String s2 = "acd";
        Assertions.assertFalse(solution1433.checkIfCanBreak(s1, s2));
    }

    @Test
    public void example3() {
        String s1 = "leetcodee";
        String s2 = "interview";
        Assertions.assertTrue(solution1433.checkIfCanBreak(s1, s2));
    }
}