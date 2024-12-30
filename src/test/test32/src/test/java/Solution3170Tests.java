import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3170Tests {
    private final Solution3170 solution3170 = new Solution3170();

    @Test
    public void example1() {
        String s = "aaba*";
        String expected = "aab";
        Assertions.assertEquals(expected, solution3170.clearStars(s));
    }

    @Test
    public void example2() {
        String s = "abc";
        String expected = "abc";
        Assertions.assertEquals(expected, solution3170.clearStars(s));
    }
}