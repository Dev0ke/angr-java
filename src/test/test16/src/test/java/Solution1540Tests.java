import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1540Tests {
    private final Solution1540 solution1540 = new Solution1540();

    @Test
    public void example1() {
        String s = "input";
        String t = "ouput";
        int k = 9;
        Assertions.assertTrue(solution1540.canConvertString(s, t, k));
    }

    @Test
    public void example2() {
        String s = "abc";
        String t = "bcd";
        int k = 10;
        Assertions.assertFalse(solution1540.canConvertString(s, t, k));
    }

    @Test
    public void example3() {
        String s = "aab";
        String t = "bbb";
        int k = 27;
        Assertions.assertTrue(solution1540.canConvertString(s, t, k));
    }
}