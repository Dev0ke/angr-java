import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution210Tests {
    private final Solution210 solution210 = new Solution210();

    @Test
    public void example1() {
        int numCourses = 2;
        int[][] prerequisites = UtUtils.stringToInts2("[[1,0]]");
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, solution210.findOrder(numCourses, prerequisites));
    }

    @Test
    public void example2() {
        int numCourses = 4;
        int[][] prerequisites = UtUtils.stringToInts2("[[1,0],[2,0],[3,1],[3,2]]");
        // 一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
//        int[] expected = {0, 2, 1, 3};
        int[] expected = {0, 1, 2, 3};
        Assertions.assertArrayEquals(expected, solution210.findOrder(numCourses, prerequisites));
    }

    @Test
    public void example3() {
        int numCourses = 1;
        int[][] prerequisites = UtUtils.stringToInts2("[]");
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solution210.findOrder(numCourses, prerequisites));
    }
}
