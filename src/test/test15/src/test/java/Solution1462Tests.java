import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1462Tests {
    private final Solution1462 solution1462 = new Solution1462();

    @Test
    public void example1() {
        int numCourses = 2;
        int[][] prerequisites = UtUtils.stringToInts2("[[1,0]]");
        int[][] queries = UtUtils.stringToInts2("[[0,1],[1,0]]");
        List<Boolean> expected = List.of(false, true);
        Assertions.assertEquals(expected, solution1462.checkIfPrerequisite(numCourses, prerequisites, queries));
    }

    @Test
    public void example2() {
        int numCourses = 2;
        int[][] prerequisites = UtUtils.stringToInts2("[]");
        int[][] queries = UtUtils.stringToInts2("[[1,0],[0,1]]");
        List<Boolean> expected = List.of(false, false);
        Assertions.assertEquals(expected, solution1462.checkIfPrerequisite(numCourses, prerequisites, queries));
    }

    @Test
    public void example3() {
        int numCourses = 3;
        int[][] prerequisites = UtUtils.stringToInts2("[[1,2],[1,0],[2,0]]");
        int[][] queries = UtUtils.stringToInts2("[[1,0],[1,2]]");
        List<Boolean> expected = List.of(true, true);
        Assertions.assertEquals(expected, solution1462.checkIfPrerequisite(numCourses, prerequisites, queries));
    }

    @Test
    public void example4() {
        int numCourses = 3;
        int[][] prerequisites = {{1, 0}, {2, 0}};
        int[][] queries = {{0, 1}, {2, 0}};
        List<Boolean> expected = List.of(false, true);
        Assertions.assertEquals(expected, solution1462.checkIfPrerequisite(numCourses, prerequisites, queries));
    }

    @Test
    public void example5() {
        int numCourses = 5;
        int[][] prerequisites = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int[][] queries = {{0, 4}, {4, 0}, {1, 3}, {3, 0}};
        List<Boolean> expected = List.of(true, false, true, false);
        Assertions.assertEquals(expected, solution1462.checkIfPrerequisite(numCourses, prerequisites, queries));
    }
}
