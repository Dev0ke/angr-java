import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1154Tests {
    private final Solution1154 solution1154 = new Solution1154();

    @Test
    public void example1() {
        String date = "2019-01-09";
        int expected = 9;
        Assertions.assertEquals(expected, solution1154.dayOfYear(date));
        Assertions.assertEquals(expected, solution1154.dayOfYear2(date));
    }

    @Test
    public void example2() {
        String date = "2019-02-10";
        int expected = 41;
        Assertions.assertEquals(expected, solution1154.dayOfYear(date));
        Assertions.assertEquals(expected, solution1154.dayOfYear2(date));
    }

    @Test
    public void example3() {
        String date = "2003-03-01";
        int expected = 60;
        Assertions.assertEquals(expected, solution1154.dayOfYear(date));
        Assertions.assertEquals(expected, solution1154.dayOfYear2(date));
    }

    @Test
    public void example4() {
        String date = "2004-03-01";
        int expected = 61;
        Assertions.assertEquals(expected, solution1154.dayOfYear(date));
        Assertions.assertEquals(expected, solution1154.dayOfYear2(date));
    }
}
