import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3225Tests {
    private final Solution3225 solution3225 = new Solution3225();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,0,0,0,0],[0,0,3,0,0],[0,1,0,0,0],[5,0,0,3,0],[0,0,0,0,2]]");
        long expected = 11;
        Assertions.assertEquals(expected, solution3225.maximumScore(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[10,9,0,0,15],[7,1,0,8,0],[5,20,0,11,0],[0,0,0,1,2],[8,12,1,10,3]]");
        long expected = 94;
        Assertions.assertEquals(expected, solution3225.maximumScore(grid));
    }
}