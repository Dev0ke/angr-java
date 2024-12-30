import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1048Tests {
    private final Solution1048 solution1048 = new Solution1048();

    @Test
    public void example1() {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        int expected = 4;
        Assertions.assertEquals(expected, solution1048.longestStrChain(words));
    }

    @Test
    public void example2() {
        String[] words = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        int expected = 5;
        Assertions.assertEquals(expected, solution1048.longestStrChain(words));
    }

    @Test
    public void example3() {
        String[] words = {"abcd", "dbqca"};
        int expected = 1;
        Assertions.assertEquals(expected, solution1048.longestStrChain(words));
    }
}
