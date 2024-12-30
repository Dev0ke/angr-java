import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution174Tests {
    private final Solution174 solution174 = new Solution174();

    @Test
    public void example1() {
        int[][] dungeon = UtUtils.stringToInts2("[[-2,-3,3],[-5,-10,1],[10,30,-5]]");
        int expected = 7;
        Assertions.assertEquals(expected, solution174.calculateMinimumHP(dungeon));
    }
}
