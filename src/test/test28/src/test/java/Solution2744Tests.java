import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2744Tests {
    private final Solution2744 solution2744 = new Solution2744();

    @Test
    public void example1() {
        String[] words = {"cd", "ac", "dc", "ca", "zz"};
        int expected = 2;
        Assertions.assertEquals(expected, solution2744.maximumNumberOfStringPairs(words));
    }

    @Test
    public void example2() {
        String[] words = {"ab", "ba", "cc"};
        int expected = 1;
        Assertions.assertEquals(expected, solution2744.maximumNumberOfStringPairs(words));
    }

    @Test
    public void example3() {
        String[] words = {"aa", "ab"};
        int expected = 0;
        Assertions.assertEquals(expected, solution2744.maximumNumberOfStringPairs(words));
    }
}