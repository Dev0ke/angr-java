import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3114Tests {
    private final Solution3114 solution3114 = new Solution3114();

    @Test
    public void example1() {
        String s = "1?:?4";
        String expected = "11:54";
        Assertions.assertEquals(expected, solution3114.findLatestTime(s));
    }

    @Test
    public void example2() {
        String s = "0?:5?";
        String expected = "09:59";
        Assertions.assertEquals(expected, solution3114.findLatestTime(s));
    }
}