import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP499Tests {
    private final SolutionP499 solutionP499 = new SolutionP499();

    @Test
    public void example1() {
        int[][] maze = UtUtils.stringToInts2("[[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]]");
        int[] ball = {4, 3};
        int[] hole = {0, 1};
        String expected = "lul";
        Assertions.assertEquals(expected, solutionP499.findShortestWay(maze, ball, hole));
    }

    @Test
    public void example2() {
        int[][] maze = UtUtils.stringToInts2("[[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]]");
        int[] ball = {4, 3};
        int[] hole = {3, 0};
        String expected = "impossible";
        Assertions.assertEquals(expected, solutionP499.findShortestWay(maze, ball, hole));
    }

    @Test
    public void example3() {
        int[][] maze = UtUtils.stringToInts2("[[0,0,0,0,0,0,0],[0,0,1,0,0,1,0],[0,0,0,0,1,0,0],[0,0,0,0,0,0,1]]");
        int[] ball = {0,4};
        int[] hole = {3, 5};
        String expected = "dldr";
        Assertions.assertEquals(expected, solutionP499.findShortestWay(maze, ball, hole));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/263570677/
        int[][] maze = UtUtils.stringToInts2("[[0,1,0,0,1,0,0,1,0,0],[0,0,1,0,0,1,0,0,1,0],[0,0,0,0,0,0,1,0,0,1],[0,0,0,0,0,0,1,0,0,1],[0,1,0,0,1,0,0,1,0,0],[0,0,1,0,0,1,0,0,0,0],[0,0,0,0,0,0,1,0,0,0],[1,0,0,1,0,0,0,0,0,1],[0,1,0,0,1,0,0,1,0,0],[0,0,0,0,0,1,0,0,1,0]]");
        int[] ball = {2, 4};
        int[] hole = {7, 6};
        String expected = "drdrdrdldl";
        Assertions.assertEquals(expected, solutionP499.findShortestWay(maze, ball, hole));
    }
}
/*
[[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]]
[4,3]
[0,1]
[[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]]
[4,3]
[3,0]
[[0,0,0,0,0,0,0],[0,0,1,0,0,1,0],[0,0,0,0,1,0,0],[0,0,0,0,0,0,1]]
[0,4]
[3,5]

"lul"
"impossible"
"dldr"

[[0,1,0,0,1,0,0,1,0,0],[0,0,1,0,0,1,0,0,1,0],[0,0,0,0,0,0,1,0,0,1],[0,0,0,0,0,0,1,0,0,1],[0,1,0,0,1,0,0,1,0,0],[0,0,1,0,0,1,0,0,0,0],[0,0,0,0,0,0,1,0,0,0],[1,0,0,1,0,0,0,0,0,1],[0,1,0,0,1,0,0,1,0,0],[0,0,0,0,0,1,0,0,1,0]]
[2,4]
[7,6]
 */