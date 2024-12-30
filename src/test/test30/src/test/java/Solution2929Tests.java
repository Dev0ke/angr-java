import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2929Tests {
    private final Solution2929 solution2929 = new Solution2929();

    @Test
    public void example1() {
        int n = 5;
        int limit = 2;
        long expected = 3;
        Assertions.assertEquals(expected, solution2929.distributeCandies2(n, limit));
    }

    @Test
    public void example2() {
        int n = 3;
        int limit = 3;
        long expected = 10;
        Assertions.assertEquals(expected, solution2929.distributeCandies2(n, limit));
    }
}