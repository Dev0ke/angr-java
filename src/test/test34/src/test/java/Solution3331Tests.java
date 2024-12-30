import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3331Tests {
    private final Solution3331 solution3331 = new Solution3331();

    @Test
    public void example1() {
        int[] parent = {-1, 0, 0, 1, 1, 1};
        String s = "abaabc";
        int[] expected = {6, 3, 1, 1, 1, 1};
        Assertions.assertArrayEquals(expected, solution3331.findSubtreeSizes(parent, s));
    }

    @Test
    public void example2() {
        int[] parent = {-1, 0, 4, 0, 1};
        String s = "abbba";
        int[] expected = {5, 2, 1, 1, 1};
        Assertions.assertArrayEquals(expected, solution3331.findSubtreeSizes(parent, s));
    }
}