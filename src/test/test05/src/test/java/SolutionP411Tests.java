import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP411Tests {
    private final SolutionP411 solutionP411 = new SolutionP411();

    @Test
    public void example1() {
        String target = "apple";
        String[] dictionary = {"blade"};
        String expected = "a4";
        Assertions.assertEquals(expected, solutionP411.minAbbreviation(target, dictionary));
    }

    @Test
    public void example2() {
        String target = "apple";
        String[] dictionary = {"blade", "plain", "amber"};
        String expected = "1p3";
        Assertions.assertEquals(expected, solutionP411.minAbbreviation(target, dictionary));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/395922372/
        // 45 / 46 个通过测试用例 TLE
        String fileName = "solution411-example3-input.txt";
        String target = UtUtils.loadingString(fileName, 0);
        String[] dictionary = UtUtils.loadingStrings(fileName, 1);
        String expected = "9s";
        Assertions.assertEquals(expected, solutionP411.minAbbreviation(target, dictionary));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/395945321/
        // TLE
        String fileName = "solution411-example4-input.txt";
        String target = UtUtils.loadingString(fileName, 0);
        String[] dictionary = UtUtils.loadingStrings(fileName, 1);
        String expected = "internationalize";
        Assertions.assertEquals(expected, solutionP411.minAbbreviation(target, dictionary));
    }
}
