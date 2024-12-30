import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2959Tests {
    private final Solution2959 solution2959 = new Solution2959();

    @Test
    public void example1() {
        int n = 3;
        int maxDistance = 5;
        int[][] roads = UtUtils.stringToInts2("[[0,1,2],[1,2,10],[0,2,10]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution2959.numberOfSets(n, maxDistance, roads));
    }

    @Test
    public void example2() {
        int n = 3;
        int maxDistance = 5;
        int[][] roads = UtUtils.stringToInts2("[[0,1,20],[0,1,10],[1,2,2],[0,2,2]]");
        int expected = 7;
        Assertions.assertEquals(expected, solution2959.numberOfSets(n, maxDistance, roads));
    }

    @Test
    public void example3() {
        int n = 1;
        int maxDistance = 10;
        int[][] roads = UtUtils.stringToInts2("[]");
        int expected = 2;
        Assertions.assertEquals(expected, solution2959.numberOfSets(n, maxDistance, roads));
    }
}