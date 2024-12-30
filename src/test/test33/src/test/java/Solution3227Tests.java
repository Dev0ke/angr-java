import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3227Tests {
    private final Solution3227 solution3227 = new Solution3227();

    @Test
    public void example1() {
        String s = "leetcoder";
        Assertions.assertTrue(solution3227.doesAliceWin(s));
    }

    @Test
    public void example2() {
        String s = "bbcd";
        Assertions.assertFalse(solution3227.doesAliceWin(s));
    }
}