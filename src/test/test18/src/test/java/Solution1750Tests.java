import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1750Tests {
    private final Solution1750 solution1750 = new Solution1750();

    @Test
    public void example1() {
        String s = "ca";
        int expected = 2;
        Assertions.assertEquals(expected, solution1750.minimumLength(s));
    }

    @Test
    public void example2() {
        String s = "cabaabac";
        int expected = 0;
        Assertions.assertEquals(expected, solution1750.minimumLength(s));
    }

    @Test
    public void example3() {
        String s = "aabccabba";
        int expected = 3;
        Assertions.assertEquals(expected, solution1750.minimumLength(s));
    }
}
