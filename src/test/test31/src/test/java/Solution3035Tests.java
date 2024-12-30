import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3035Tests {
    private final Solution3035 solution3035 = new Solution3035();

    @Test
    public void example1() {
        String[] words = {"abbb", "ba", "aa"};
        int expected = 3;
        Assertions.assertEquals(expected, solution3035.maxPalindromesAfterOperations(words));
    }

    @Test
    public void example2() {
        String[] words = {"abc", "ab"};
        int expected = 2;
        Assertions.assertEquals(expected, solution3035.maxPalindromesAfterOperations(words));
    }

    @Test
    public void example3() {
        String[] words = {"cd", "ef", "a"};
        int expected = 1;
        Assertions.assertEquals(expected, solution3035.maxPalindromesAfterOperations(words));
    }
}