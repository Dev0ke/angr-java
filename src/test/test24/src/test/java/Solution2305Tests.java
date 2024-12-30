import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2305Tests {
    private final Solution2305 solution2305 = new Solution2305();

    @Test
    public void example1() {
        int[] cookies = {8, 15, 10, 20, 8};
        int k = 2;
        int expected = 31;
        Assertions.assertEquals(expected, solution2305.distributeCookies(cookies, k));
    }

    @Test
    public void example2() {
        int[] cookies = {6, 1, 3, 2, 2, 4, 1, 2};
        int k = 3;
        int expected = 7;
        Assertions.assertEquals(expected, solution2305.distributeCookies(cookies, k));
    }
}
