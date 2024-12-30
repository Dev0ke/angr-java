import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution826Tests {
    private final Solution826 solution826 = new Solution826();

    @Test
    public void example1() {
        int[] difficulty = {2, 4, 6, 8, 10};
        int[] profit = {10, 20, 30, 40, 50};
        int[] worker = {4, 5, 6, 7};
        int expected = 100;
        Assertions.assertEquals(expected, solution826.maxProfitAssignment(difficulty, profit, worker));
    }

    @Test
    public void example2() {
        int[] difficulty = {85, 47, 57};
        int[] profit = {24, 66, 99};
        int[] worker = {40, 25, 25};
        int expected = 0;
        Assertions.assertEquals(expected, solution826.maxProfitAssignment(difficulty, profit, worker));
    }
}
