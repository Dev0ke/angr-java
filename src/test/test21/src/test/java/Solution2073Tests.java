import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2073Tests {
    private final Solution2073 solution2073 = new Solution2073();

    @Test
    public void example1() {
        int[] tickets = {2, 3, 2};
        int k = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solution2073.timeRequiredToBuy(tickets, k));
    }

    @Test
    public void example2() {
        int[] tickets = {5, 1, 1, 1};
        int k = 0;
        int expected = 8;
        Assertions.assertEquals(expected, solution2073.timeRequiredToBuy(tickets, k));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] tickets = {84, 49, 5, 24, 70, 77, 87, 8};
        int k = 3;
        int expected = 154;
        Assertions.assertEquals(expected, solution2073.timeRequiredToBuy(tickets, k));
    }
}
