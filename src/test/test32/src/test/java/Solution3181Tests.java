import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3181Tests {
    private final Solution3181 solution3181 = new Solution3181();

    @Test
    public void example1() {
        int[] rewardValues = {1, 1, 3, 3};
        int expected = 4;
        Assertions.assertEquals(expected, solution3181.maxTotalReward(rewardValues));
        Assertions.assertEquals(expected, solution3181.maxTotalReward2(rewardValues));
    }

    @Test
    public void example2() {
        int[] rewardValues = {1, 6, 4, 3, 2};
        int expected = 11;
        Assertions.assertEquals(expected, solution3181.maxTotalReward(rewardValues));
        Assertions.assertEquals(expected, solution3181.maxTotalReward2(rewardValues));
    }
}