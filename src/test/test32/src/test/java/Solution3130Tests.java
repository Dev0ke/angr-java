import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3130Tests {
    private final Solution3130 solution3130 = new Solution3130();

    @Test
    public void example1() {
        int zero = 1;
        int one = 1;
        int limit = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution3130.numberOfStableArrays(zero, one, limit));
    }

    @Test
    public void example2() {
        int zero = 1;
        int one = 2;
        int limit = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution3130.numberOfStableArrays(zero, one, limit));
    }

    @Test
    public void example3() {
        int zero = 3;
        int one = 3;
        int limit = 2;
        int expected = 14;
        Assertions.assertEquals(expected, solution3130.numberOfStableArrays(zero, one, limit));
    }
}