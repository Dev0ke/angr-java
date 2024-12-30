import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1067Tests {
    private final SolutionP1067 solutionP1067 = new SolutionP1067();

    @Test
    public void example1() {
        int d = 1;
        int low = 1;
        int high = 13;
        int expected = 6;
        Assertions.assertEquals(expected, solutionP1067.digitsCount(d, low, high));
    }

    @Test
    public void example2() {
        int d = 3;
        int low = 100;
        int high = 250;
        int expected = 35;
        Assertions.assertEquals(expected, solutionP1067.digitsCount(d, low, high));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/350171359/
        int d = 1;
        int low = 1;
        int high = 10;
        int expected = 2;
        Assertions.assertEquals(expected, solutionP1067.digitsCount(d, low, high));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/367150722/
        // 不能去掉 isNum，否则 d = 0 时出问题
        int d = 0;
        int low = 1;
        int high = 10;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP1067.digitsCount(d, low, high));
    }
}
