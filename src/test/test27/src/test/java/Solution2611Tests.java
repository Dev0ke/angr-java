import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2611Tests {
    private final Solution2611 solution2611 = new Solution2611();

    @Test
    public void example1() {
        int[] reward1 = {1, 1, 3, 4};
        int[] reward2 = {4, 4, 1, 1};
        int k = 2;
        int expected = 15;
        Assertions.assertEquals(expected, solution2611.miceAndCheese(reward1, reward2, k));
    }

    @Test
    public void example2() {
        int[] reward1 = {1, 1};
        int[] reward2 = {1, 1};
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution2611.miceAndCheese(reward1, reward2, k));
    }
}