import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution22Tests {
    private final Solution22 solution22 = new Solution22();

    @Test
    public void example1() {
        int n = 3;
        List<String> expected = List.of("((()))", "(()())", "(())()", "()(())", "()()()");
        Assertions.assertEquals(expected, solution22.generateParenthesis(n));
    }

    @Test
    public void example2() {
        int n = 1;
        List<String> expected = List.of("()");
        Assertions.assertEquals(expected, solution22.generateParenthesis(n));
    }
}
