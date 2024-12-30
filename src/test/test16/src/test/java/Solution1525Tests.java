import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1525Tests {
    private final Solution1525 solution1525 = new Solution1525();

    @Test
    public void example1() {
        String s = "aacaba";
        int expected = 2;
        Assertions.assertEquals(expected, solution1525.numSplits(s));
    }

    @Test
    public void example2() {
        String s = "abcd";
        int expected = 1;
        Assertions.assertEquals(expected, solution1525.numSplits(s));
    }

    @Test
    public void example3() {
        String s = "aaaaa";
        int expected = 4;
        Assertions.assertEquals(expected, solution1525.numSplits(s));
    }

    @Test
    public void example4() {
        String s = "acbadbaada";
        int expected = 2;
        Assertions.assertEquals(expected, solution1525.numSplits(s));
    }
}