import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution942Tests {
    private final Solution942 solution942 = new Solution942();

    @Test
    public void example1() {
        String s = "IDID";
        int[] expected = {0, 4, 1, 3, 2};
        Assertions.assertArrayEquals(expected, solution942.diStringMatch(s));
    }

    @Test
    public void example2() {
        String s = "III";
        int[] expected = {0, 1, 2, 3};
        Assertions.assertArrayEquals(expected, solution942.diStringMatch(s));
    }

    @Test
    public void example3() {
        String s = "DDI";
        int[] expected = {3, 2, 0, 1};
        Assertions.assertArrayEquals(expected, solution942.diStringMatch(s));
    }
}