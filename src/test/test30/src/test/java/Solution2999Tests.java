import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2999Tests {
    private final Solution2999 solution2999 = new Solution2999();
    private final Solution2999.V2 solution2999_v2 = new Solution2999.V2();

    @Test
    public void example1() {
        long start = 1;
        long finish = 6000;
        int limit = 4;
        String s = "124";
        long expected = 5;
        Assertions.assertEquals(expected, solution2999.numberOfPowerfulInt(start, finish, limit, s));
        Assertions.assertEquals(expected, solution2999_v2.numberOfPowerfulInt(start, finish, limit, s));
    }

    @Test
    public void example2() {
        long start = 15;
        long finish = 215;
        int limit = 6;
        String s = "10";
        long expected = 2;
        Assertions.assertEquals(expected, solution2999.numberOfPowerfulInt(start, finish, limit, s));
        Assertions.assertEquals(expected, solution2999_v2.numberOfPowerfulInt(start, finish, limit, s));
    }

    @Test
    public void example3() {
        long start = 1000;
        long finish = 2000;
        int limit = 4;
        String s = "3000";
        long expected = 0;
        Assertions.assertEquals(expected, solution2999.numberOfPowerfulInt(start, finish, limit, s));
        Assertions.assertEquals(expected, solution2999_v2.numberOfPowerfulInt(start, finish, limit, s));
    }
}