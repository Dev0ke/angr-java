import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution647Tests {
    private final Solution647 solution647 = new Solution647();

    @Test
    public void example1() {
        String s = "abc";
        int expected = 3;
        Assertions.assertEquals(expected, solution647.countSubstrings(s));
        Assertions.assertEquals(expected, solution647.countSubstrings2(s));
    }

    @Test
    public void example2() {
        String s = "aaa";
        int expected = 6;
        Assertions.assertEquals(expected, solution647.countSubstrings(s));
        Assertions.assertEquals(expected, solution647.countSubstrings2(s));
    }
}
