import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution846Tests {
    private final Solution846 solution846 = new Solution846();

    @Test
    public void example1() {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;
        Assertions.assertTrue(solution846.isNStraightHand(hand, groupSize));
    }

    @Test
    public void example2() {
        int[] hand = {1, 2, 3, 4, 5};
        int groupSize = 4;
        Assertions.assertFalse(solution846.isNStraightHand(hand, groupSize));
    }
}
