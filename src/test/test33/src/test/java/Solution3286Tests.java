import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3286Tests {
    private final Solution3286.V1 solution3286_v1 = new Solution3286.V1();
    private final Solution3286.V2 solution3286_v2 = new Solution3286.V2();

    @Test
    public void example1() {
        List<List<Integer>> grid = UtUtils.stringToIntegerList2("[[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]");
        int health = 1;
        Assertions.assertTrue(solution3286_v1.findSafeWalk(grid, health));
        Assertions.assertTrue(solution3286_v2.findSafeWalk(grid, health));
    }

    @Test
    public void example2() {
        List<List<Integer>> grid = UtUtils.stringToIntegerList2("[[0,1,1,0,0,0],[1,0,1,0,0,0],[0,1,1,1,0,1],[0,0,1,0,1,0]]");
        int health = 3;
        Assertions.assertFalse(solution3286_v1.findSafeWalk(grid, health));
        Assertions.assertFalse(solution3286_v2.findSafeWalk(grid, health));
    }

    @Test
    public void example3() {
        List<List<Integer>> grid = UtUtils.stringToIntegerList2("[[1,1,1],[1,0,1],[1,1,1]]");
        int health = 5;
        Assertions.assertTrue(solution3286_v1.findSafeWalk(grid, health));
        Assertions.assertTrue(solution3286_v2.findSafeWalk(grid, health));
    }
}