import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution207Tests {
    private final Solution207 solution207 = new Solution207();

    @Test
    public void example1() {
        int numCourses = 2;
        int[][] prerequisites = UtUtils.stringToInts2("[[1,0]]");
        Assertions.assertTrue(solution207.canFinish(numCourses, prerequisites));
    }

    @Test
    public void example2() {
        int numCourses = 2;
        int[][] prerequisites = UtUtils.stringToInts2("[[1,0],[0,1]]");
        Assertions.assertFalse(solution207.canFinish(numCourses, prerequisites));
    }
}
