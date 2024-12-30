import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution844Tests {
    private final Solution844 solution844 = new Solution844();

    @Test
    public void example1() {
        String s = "ab#c";
        String t = "ad#c";
        Assertions.assertTrue(solution844.backspaceCompare(s, t));
    }

    @Test
    public void example2() {
        String s = "ab##";
        String t = "c#d#";
        Assertions.assertTrue(solution844.backspaceCompare(s, t));
    }

    @Test
    public void example3() {
        String s = "a##c";
        String t = "#a#c";
        Assertions.assertTrue(solution844.backspaceCompare(s, t));
    }

    @Test
    public void example4() {
        String s = "a#c";
        String t = "b";
        Assertions.assertFalse(solution844.backspaceCompare(s, t));
    }
}
