import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP252Tests {
    private final SolutionP252 solutionP252 = new SolutionP252();

    @Test
    public void example1() {
        int[][] intervals = UtUtils.stringToInts2("[[0,30],[5,10],[15,20]]");
        Assertions.assertFalse(solutionP252.canAttendMeetings(intervals));
    }

    @Test
    public void example2() {
        int[][] intervals = UtUtils.stringToInts2("[[7,10],[2,4]]");
        Assertions.assertTrue(solutionP252.canAttendMeetings(intervals));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/225516763/
        int[][] intervals = UtUtils.stringToInts2("[]");
        Assertions.assertTrue(solutionP252.canAttendMeetings(intervals));
    }
}
