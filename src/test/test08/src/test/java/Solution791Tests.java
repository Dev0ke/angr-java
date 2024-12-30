import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution791Tests {
    private final Solution791 solution791 = new Solution791();

    @Test
    public void example1() {
        String order = "cba";
        String s = "abcd";
        String expected = "cbad";
        Assertions.assertEquals(expected, solution791.customSortString(order, s));
    }

    @Test
    public void example2() {
        String order = "cbafg";
        String s = "abcd";
        String expected = "cbad";
        Assertions.assertEquals(expected, solution791.customSortString(order, s));
    }
}
