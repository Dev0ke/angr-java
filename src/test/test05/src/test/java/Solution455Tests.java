import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution455Tests {
    private final Solution455 solution455 = new Solution455();

    @Test
    public void example1() {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution455.findContentChildren(g, s));
    }

    @Test
    public void example2() {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution455.findContentChildren(g, s));
    }
}
