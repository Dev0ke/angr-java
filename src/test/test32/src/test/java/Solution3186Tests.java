import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3186Tests {
    private final Solution3186 solution3186 = new Solution3186();

    @Test
    public void example1() {
        int[] power = {1, 1, 3, 4};
        long expected = 6;
        Assertions.assertEquals(expected, solution3186.maximumTotalDamage(power));
    }

    @Test
    public void example2() {
        int[] power = {7, 1, 6, 6};
        long expected = 13;
        Assertions.assertEquals(expected, solution3186.maximumTotalDamage(power));
    }
}