import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3226Tests {
    private final Solution3226 solution3226 = new Solution3226();

    @Test
    public void example1() {
        int n = 13;
        int k = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution3226.minChanges(n, k));
    }

    @Test
    public void example2() {
        int n = 21;
        int k = 21;
        int expected = 0;
        Assertions.assertEquals(expected, solution3226.minChanges(n, k));
    }

    @Test
    public void example3() {
        int n = 14;
        int k = 13;
        int expected = -1;
        Assertions.assertEquals(expected, solution3226.minChanges(n, k));
    }
}