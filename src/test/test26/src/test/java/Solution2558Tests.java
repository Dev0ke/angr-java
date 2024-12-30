import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2558Tests {
    private final Solution2558 solution2558 = new Solution2558();

    @Test
    public void example1() {
        int[] gifts = {25, 64, 9, 4, 100};
        int k = 4;
        long expected = 29;
        Assertions.assertEquals(expected, solution2558.pickGifts(gifts, k));
    }

    @Test
    public void example2() {
        int[] gifts = {1, 1, 1, 1};
        int k = 4;
        long expected = 4;
        Assertions.assertEquals(expected, solution2558.pickGifts(gifts, k));
    }
}