import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution679Tests {
    private final Solution679 solution679 = new Solution679();

    @Test
    public void example1() {
        int[] cards = {4, 1, 8, 7};
        Assertions.assertTrue(solution679.judgePoint24(cards));
        Assertions.assertTrue(solution679.judgePoint242(cards));
    }

    @Test
    public void example2() {
        int[] cards = {1, 2, 1, 2};
        Assertions.assertFalse(solution679.judgePoint24(cards));
        Assertions.assertFalse(solution679.judgePoint242(cards));
    }
}
