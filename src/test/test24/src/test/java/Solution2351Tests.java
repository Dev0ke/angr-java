import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2351Tests {
    private final Solution2351 solution2351 = new Solution2351();

    @Test
    public void example1() {
        String s = "abccbaacz";
        char expected = 'c';
        Assertions.assertEquals(expected, solution2351.repeatedCharacter(s));
    }

    @Test
    public void example2() {
        String s = "abcdd";
        char expected = 'd';
        Assertions.assertEquals(expected, solution2351.repeatedCharacter(s));
    }
}
