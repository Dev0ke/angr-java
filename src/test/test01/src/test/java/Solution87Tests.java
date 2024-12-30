import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution87Tests {
    private final Solution87 solution87 = new Solution87();

    @Test
    public void example1() {
        String s1 = "great";
        String s2 = "rgeat";
        Assertions.assertTrue(solution87.isScramble(s1, s2));
    }

    @Test
    public void example2() {
        String s1 = "abcde";
        String s2 = "caebd";
        Assertions.assertFalse(solution87.isScramble(s1, s2));
    }

    @Test
    public void example3() {
        String s1 = "a";
        String s2 = "a";
        Assertions.assertTrue(solution87.isScramble(s1, s2));
    }
}
