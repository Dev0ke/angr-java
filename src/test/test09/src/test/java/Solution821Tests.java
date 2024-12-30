import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution821Tests {
    private final Solution821 solution821 = new Solution821();

    @Test
    public void example1() {
        String s = "loveleetcode";
        char c = 'e';
        int[] expected = {3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0};
        Assertions.assertArrayEquals(expected, solution821.shortestToChar(s, c));
    }

    @Test
    public void example2() {
        String s = "aaab";
        char c = 'b';
        int[] expected = {3, 2, 1, 0};
        Assertions.assertArrayEquals(expected, solution821.shortestToChar(s, c));
    }
}
