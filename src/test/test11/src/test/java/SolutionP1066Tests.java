import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1066Tests {
    private final SolutionP1066 solutionP1066 = new SolutionP1066();

    @Test
    public void example1() {
        int[][] workers = UtUtils.stringToInts2("[[0,0],[2,1]]");
        int[][] bikes = UtUtils.stringToInts2("[[1,2],[3,3]]");
        int expected = 6;
        Assertions.assertEquals(expected, solutionP1066.assignBikes(workers, bikes));
    }

    @Test
    public void example2() {
        int[][] workers = UtUtils.stringToInts2("[[0,0],[1,1],[2,0]]");
        int[][] bikes = UtUtils.stringToInts2("[[1,0],[2,2],[2,1]]");
        int expected = 4;
        Assertions.assertEquals(expected, solutionP1066.assignBikes(workers, bikes));
    }

    @Test
    public void example3() {
        int[][] workers = UtUtils.stringToInts2("[[0,0],[1,0],[2,0],[3,0],[4,0]]");
        int[][] bikes = UtUtils.stringToInts2("[[0,999],[1,999],[2,999],[3,999],[4,999]]");
        int expected = 4995;
        Assertions.assertEquals(expected, solutionP1066.assignBikes(workers, bikes));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/245207543/
        int[][] workers = UtUtils.stringToInts2("[[0,0],[1,0],[2,0],[3,0],[4,0]]");
        int[][] bikes = UtUtils.stringToInts2("[[0,999],[1,999],[2,999],[3,999],[4,999],[5,999],[6,999],[7,999],[8,999],[9,999]]");
        int expected = 4995;
        Assertions.assertEquals(expected, solutionP1066.assignBikes(workers, bikes));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/245320548/
        int[][] workers = UtUtils.stringToInts2("[[239,904],[191,103],[260,117],[86,78],[747,62]]");
        int[][] bikes = UtUtils.stringToInts2("[[660,8],[431,772],[78,576],[894,481],[451,730],[155,28]]");
        int expected = 1886;
        Assertions.assertEquals(expected, solutionP1066.assignBikes(workers, bikes));
    }
}
/*
[[0,0],[1,0],[2,0],[3,0],[4,0]]
[[0,999],[1,999],[2,999],[3,999],[4,999],[5,999],[6,999],[7,999],[8,999],[9,999]]

[[239,904],[191,103],[260,117],[86,78],[747,62]]
[[660,8],[431,772],[78,576],[894,481],[451,730],[155,28]]
 */