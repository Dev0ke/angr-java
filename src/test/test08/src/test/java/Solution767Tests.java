import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution767Tests {
    private final Solution767 solution767 = new Solution767();

    @Test
    public void example1() {
        String s = "aab";
        String expected = "aba";
        Assertions.assertEquals(expected, solution767.reorganizeString(s));
    }

    @Test
    public void example2() {
        String s = "aaab";
        String expected = "";
        Assertions.assertEquals(expected, solution767.reorganizeString(s));
    }
}
