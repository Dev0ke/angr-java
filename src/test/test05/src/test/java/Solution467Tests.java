import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution467Tests {
    private final Solution467 solution467 = new Solution467();

    @Test
    public void example1() {
        String s = "a";
        int expected = 1;
        Assertions.assertEquals(expected, solution467.findSubstringInWraproundString(s));
    }

    @Test
    public void example2() {
        String s = "cac";
        int expected = 2;
        Assertions.assertEquals(expected, solution467.findSubstringInWraproundString(s));
    }

    @Test
    public void example3() {
        String s = "zab";
        int expected = 6;
        Assertions.assertEquals(expected, solution467.findSubstringInWraproundString(s));
    }
}