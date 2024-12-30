import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution828Tests {
    private final Solution828 solution828 = new Solution828();

    @Test
    public void example1() {
        String s = "ABC";
        int expected = 10;
        Assertions.assertEquals(expected, solution828.uniqueLetterString(s));
    }

    @Test
    public void example2() {
        String s = "ABA";
        int expected = 8;
        Assertions.assertEquals(expected, solution828.uniqueLetterString(s));
    }

    @Test
    public void example3() {
        String s = "LEETCODE";
        int expected = 92;
        Assertions.assertEquals(expected, solution828.uniqueLetterString(s));
    }
}
