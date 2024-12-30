import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution761Tests {
    private final Solution761 solution761 = new Solution761();

    @Test
    public void example1() {
        String s = "11011000";
        String expected = "11100100";
        Assertions.assertEquals(expected, solution761.makeLargestSpecial(s));
    }
}