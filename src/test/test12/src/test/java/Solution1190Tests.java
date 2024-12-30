import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1190Tests {
    private final Solution1190 solution1190 = new Solution1190();

    @Test
    public void example1() {
        String s = "(abcd)";
        String expected = "dcba";
        Assertions.assertEquals(expected, solution1190.reverseParentheses(s));
    }

    @Test
    public void example2() {
        String s = "(u(love)i)";
        String expected = "iloveu";
        Assertions.assertEquals(expected, solution1190.reverseParentheses(s));
    }

    @Test
    public void example3() {
        String s = "(ed(et(oc))el)";
        String expected = "leetcode";
        Assertions.assertEquals(expected, solution1190.reverseParentheses(s));
    }

    @Test
    public void example4() {
        String s = "a(bcdefghijkl(mno)p)q";
        String expected = "apmnolkjihgfedcbq";
        Assertions.assertEquals(expected, solution1190.reverseParentheses(s));
    }
}