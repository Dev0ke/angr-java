import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1904Tests {
    private final Solution1904 solution1904 = new Solution1904();

    @Test
    public void example1() {
        String startTime = "12:01";
        String finishTime = "12:44";
        int expected = 1;
        Assertions.assertEquals(expected, solution1904.numberOfRounds(startTime, finishTime));
    }

    @Test
    public void example2() {
        String startTime = "20:00";
        String finishTime = "06:00";
        int expected = 40;
        Assertions.assertEquals(expected, solution1904.numberOfRounds(startTime, finishTime));
    }

    @Test
    public void example3() {
        String startTime = "00:00";
        String finishTime = "23:59";
        int expected = 95;
        Assertions.assertEquals(expected, solution1904.numberOfRounds(startTime, finishTime));
    }

    /**
     * 86 / 90 个通过测试用例。
     */
    @Test
    public void example4() {
        String startTime = "00:47";
        String finishTime = "00:57";
        int expected = 0;
        Assertions.assertEquals(expected, solution1904.numberOfRounds(startTime, finishTime));
    }
}
