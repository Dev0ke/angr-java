import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1014Tests {
    private final Solution1014 solution1014 = new Solution1014();

    @Test
    public void example1() {
        int[] values = {8, 1, 5, 2, 6};
        int expected = 11;
        Assertions.assertEquals(expected, solution1014.maxScoreSightseeingPair(values));
    }

    @Test
    public void example2() {
        int[] values = {1, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution1014.maxScoreSightseeingPair(values));
    }
}
