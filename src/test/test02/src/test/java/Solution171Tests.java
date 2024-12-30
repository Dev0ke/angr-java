import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution171Tests {
    private final Solution171 solution171 = new Solution171();

    @Test
    public void example1() {
        String columnTitle = "A";
        int expected = 1;
        Assertions.assertEquals(expected, solution171.titleToNumber(columnTitle));
    }

    @Test
    public void example2() {
        String columnTitle = "AB";
        int expected = 28;
        Assertions.assertEquals(expected, solution171.titleToNumber(columnTitle));
    }

    @Test
    public void example3() {
        String columnTitle = "ZY";
        int expected = 701;
        Assertions.assertEquals(expected, solution171.titleToNumber(columnTitle));
    }
}
