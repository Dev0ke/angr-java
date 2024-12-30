import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3216Tests {
    private final Solution3216 solution3216 = new Solution3216();

    @Test
    public void example1() {
        String s = "45320";
        String expected = "43520";
        Assertions.assertEquals(expected, solution3216.getSmallestString(s));
    }

    @Test
    public void example2() {
        String s = "001";
        String expected = "001";
        Assertions.assertEquals(expected, solution3216.getSmallestString(s));
    }
}