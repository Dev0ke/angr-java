import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3361Tests {
    private final Solution3361 solution3361 = new Solution3361();

    @Test
    public void example1() {
        String s = "abab";
        String t = "baba";
        int[] nextCost = {100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] previousCost = {1, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        long expected = 2;
        Assertions.assertEquals(expected, solution3361.shiftDistance(s, t, nextCost, previousCost));
    }

    @Test
    public void example2() {
        String s = "leet";
        String t = "code";
        int[] nextCost = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] previousCost = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        long expected = 31;
        Assertions.assertEquals(expected, solution3361.shiftDistance(s, t, nextCost, previousCost));
    }
}