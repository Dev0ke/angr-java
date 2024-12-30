import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution301Tests {
    private final Solution301 solution301 = new Solution301();

    @Test
    public void example1() {
        String s = "()())()";
        List<String> expected = new ArrayList<>(List.of("(())()", "()()()"));
        List<String> actual = solution301.removeInvalidParentheses(s);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String s = "(a)())()";
        List<String> expected = new ArrayList<>(List.of("(a())()", "(a)()()"));
        List<String> actual = solution301.removeInvalidParentheses(s);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        String s = ")(";
        List<String> expected = new ArrayList<>(List.of(""));
        List<String> actual = solution301.removeInvalidParentheses(s);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}
