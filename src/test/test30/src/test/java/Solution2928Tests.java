import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2928Tests {
    private final Solution2928 solution2928 = new Solution2928();

    @Test
    public void example1() {
        int n = 5;
        int limit = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution2928.distributeCandies(n, limit));
    }

    @Test
    public void example2() {
        int n = 3;
        int limit = 3;
        int expected = 10;
        Assertions.assertEquals(expected, solution2928.distributeCandies(n, limit));
    }
}