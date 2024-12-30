import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3174Tests {
    private final Solution3174 solution3174 = new Solution3174();

    @Test
    public void example1() {
        String s = "abc";
        String expected = "abc";
        Assertions.assertEquals(expected, solution3174.clearDigits(s));
    }

    @Test
    public void example2() {
        String s = "cb34";
        String expected = "";
        Assertions.assertEquals(expected, solution3174.clearDigits(s));
    }
}