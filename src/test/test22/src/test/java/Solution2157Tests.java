import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2157Tests {
    private final Solution2157 solution2157 = new Solution2157();

    @Test
    public void example1() {
        String[] words = {"a", "b", "ab", "cde"};
        int[] expected = {2, 3};
        Assertions.assertArrayEquals(expected, solution2157.groupStrings(words));
    }

    @Test
    public void example2() {
        String[] words = {"a", "ab", "abc"};
        int[] expected = {1, 3};
        Assertions.assertArrayEquals(expected, solution2157.groupStrings(words));
    }
}
