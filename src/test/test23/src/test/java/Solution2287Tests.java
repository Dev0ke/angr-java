import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2287Tests {
    private final Solution2287 solution2287 = new Solution2287();

    @Test
    public void example1() {
        String s = "ilovecodingonleetcode";
        String target = "code";
        int expected = 2;
        Assertions.assertEquals(expected, solution2287.rearrangeCharacters(s, target));
    }

    @Test
    public void example2() {
        String s = "abcba";
        String target = "abc";
        int expected = 1;
        Assertions.assertEquals(expected, solution2287.rearrangeCharacters(s, target));
    }

    @Test
    public void example3() {
        String s = "abbaccaddaeea";
        String target = "aaaaa";
        int expected = 1;
        Assertions.assertEquals(expected, solution2287.rearrangeCharacters(s, target));
    }
}
