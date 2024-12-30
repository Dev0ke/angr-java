import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution877Tests {
    private final Solution877 solution877 = new Solution877();

    @Test
    public void example1() {
        int[] piles = {5, 3, 4, 5};
        Assertions.assertTrue(solution877.stoneGame(piles));
    }
}
