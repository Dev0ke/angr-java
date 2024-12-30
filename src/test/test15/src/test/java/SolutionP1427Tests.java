import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1427Tests {
    private final SolutionP1427 solutionP1427 = new SolutionP1427();

    @Test
    public void example1() {
        String s = "abc";
        int[][] shift = UtUtils.stringToInts2("[[0,1],[1,2]]");
        String expected = "cab";
        Assertions.assertEquals(expected, solutionP1427.stringShift(s, shift));
    }

    @Test
    public void example2() {
        String s = "abcdefg";
        int[][] shift = UtUtils.stringToInts2("[[1,1],[1,1],[0,2],[1,3]]");
        String expected = "efgabcd";
        Assertions.assertEquals(expected, solutionP1427.stringShift(s, shift));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/285033113/
        String s = "mecsk";
        int[][] shift = UtUtils.stringToInts2("[[1,4],[0,5],[0,4],[1,1],[1,5]]");
        String expected = "kmecs";
        Assertions.assertEquals(expected, solutionP1427.stringShift(s, shift));
    }
}
