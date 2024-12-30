import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution778Tests {
    private final Solution778 solution778 = new Solution778();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,2],[1,3]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution778.swimInWater(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]");
        int expected = 16;
        Assertions.assertEquals(expected, solution778.swimInWater(grid));
    }
}
