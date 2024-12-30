import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3154Tests {
    private final Solution3154 solution3154 = new Solution3154();

    @Test
    public void example1() {
        int k = 0;
        int expected = 2;
        Assertions.assertEquals(expected, solution3154.waysToReachStair(k));
    }

    @Test
    public void example2() {
        int k = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution3154.waysToReachStair(k));
    }
}