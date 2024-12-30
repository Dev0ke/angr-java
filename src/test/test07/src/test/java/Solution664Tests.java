import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution664Tests {
    private final Solution664 solution664 = new Solution664();

    @Test
    public void example1() {
        String s = "aaabbb";
        int expected = 2;
        Assertions.assertEquals(expected, solution664.strangePrinter(s));
    }

    @Test
    public void example2() {
        String s = "aba";
        int expected = 2;
        Assertions.assertEquals(expected, solution664.strangePrinter(s));
    }
}
