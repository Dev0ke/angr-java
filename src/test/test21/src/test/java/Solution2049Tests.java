import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2049Tests {
    private final Solution2049 solution2049 = new Solution2049();

    @Test
    public void example1() {
        int[] parents = {-1, 2, 0, 2, 0};
        int expected = 3;
        Assertions.assertEquals(expected, solution2049.countHighestScoreNodes(parents));
    }

    @Test
    public void example2() {
        int[] parents = {-1,2,0};
        int expected = 2;
        Assertions.assertEquals(expected, solution2049.countHighestScoreNodes(parents));
    }
}
