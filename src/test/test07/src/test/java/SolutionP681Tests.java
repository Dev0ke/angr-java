import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP681Tests {
    private final SolutionP681 solutionP681 = new SolutionP681();

    @Test
    public void example1() {
        String time = "19:34";
        String expected = "19:39";
        Assertions.assertEquals(expected, solutionP681.nextClosestTime(time));
    }

    @Test
    public void example2() {
        String time = "23:59";
        String expected = "22:22";
        Assertions.assertEquals(expected, solutionP681.nextClosestTime(time));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/397925872/
        String time = "00:00";
        String expected = "00:00";
        Assertions.assertEquals(expected, solutionP681.nextClosestTime(time));
    }
}