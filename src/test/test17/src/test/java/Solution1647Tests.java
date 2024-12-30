import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1647Tests {
    private final Solution1647 solution1647 = new Solution1647();

    @Test
    public void example1() {
        String s = "aab";
        int expected = 0;
        Assertions.assertEquals(expected, solution1647.minDeletions(s));
    }

    @Test
    public void example2() {
        String s = "aaabbbcc";
        int expected = 2;
        Assertions.assertEquals(expected, solution1647.minDeletions(s));
    }

    @Test
    public void example3() {
        String s = "ceabaacb";
        int expected = 2;
        Assertions.assertEquals(expected, solution1647.minDeletions(s));
    }
}