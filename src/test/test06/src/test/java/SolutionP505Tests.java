import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP505Tests {
    private final SolutionP505 solutionP505 = new SolutionP505();

    @Test
    public void example1() {
        int[][] maze = UtUtils.stringToInts2("[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]");
        int[] start = {0, 4};
        int[] destination = {4, 4};
        int expected = 12;
        Assertions.assertEquals(expected, solutionP505.shortestDistance(maze, start, destination));
    }

    @Test
    public void example2() {
        int[][] maze = UtUtils.stringToInts2("[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]");
        int[] start = {0, 4};
        int[] destination = {3, 2};
        int expected = -1;
        Assertions.assertEquals(expected, solutionP505.shortestDistance(maze, start, destination));
    }

    @Test
    public void example3() {
        int[][] maze = UtUtils.stringToInts2("[[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]]");
        int[] start = {4, 3};
        int[] destination = {0, 1};
        int expected = -1;
        Assertions.assertEquals(expected, solutionP505.shortestDistance(maze, start, destination));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/263535657/
        int[][] maze = UtUtils.loadingInts2("solution505-example3-input.txt", 0);
        int[] start = UtUtils.loadingInts("solution505-example3-input.txt", 1);
        int[] destination = UtUtils.loadingInts("solution505-example3-input.txt", 2);
        int expected = 192;
        Assertions.assertEquals(expected, solutionP505.shortestDistance(maze, start, destination));
    }
}
/*
[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
[0,4]
[4,4]
[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
[0,4]
[3,2]
[[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]]
[4,3]
[0,1]

12
-1
-1
 */