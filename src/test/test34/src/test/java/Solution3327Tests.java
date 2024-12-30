import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3327Tests {
    private final Solution3327 solution3327 = new Solution3327();

    @Test
    public void example1() {
        int[] parent = {-1, 0, 0, 1, 1, 2};
        String s = "aababa";
        boolean[] expected = {true, true, false, true, true, true};
        Assertions.assertArrayEquals(expected, solution3327.findAnswer(parent, s));
    }

    @Test
    public void example2() {
        int[] parent = {-1, 0, 0, 0, 0};
        String s = "aabcb";
        boolean[] expected = {true, true, true, true, true};
        Assertions.assertArrayEquals(expected, solution3327.findAnswer(parent, s));
    }
}