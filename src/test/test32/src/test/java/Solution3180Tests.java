import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3180Tests {
    private final Solution3180 solution3180 = new Solution3180();

    @Test
    public void example1() {
        int[] rewardValues = {1, 1, 3, 3};
        int expected = 4;
        Assertions.assertEquals(expected, solution3180.maxTotalReward(rewardValues));
    }

    @Test
    public void example2() {
        int[] rewardValues = {1, 6, 4, 3, 2};
        int expected = 11;
        Assertions.assertEquals(expected, solution3180.maxTotalReward(rewardValues));
    }
}