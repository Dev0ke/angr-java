import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2746Tests {
    private final Solution2746 solution2746 = new Solution2746();

    @Test
    public void example1() {
        String[] words = {"aa", "ab", "bc"};
        int expected = 4;
        Assertions.assertEquals(expected, solution2746.minimizeConcatenatedLength(words));
    }

    @Test
    public void example2() {
        String[] words = {"ab", "b"};
        int expected = 2;
        Assertions.assertEquals(expected, solution2746.minimizeConcatenatedLength(words));
    }

    @Test
    public void example3() {
        String[] words = {"aaa", "c", "aba"};
        int expected = 6;
        Assertions.assertEquals(expected, solution2746.minimizeConcatenatedLength(words));
    }
}