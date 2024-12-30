import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1624Tests {
    private final Solution1624 solution1624 = new Solution1624();

    @Test
    public void example1() {
        String s = "aa";
        int expected = 0;
        Assertions.assertEquals(expected, solution1624.maxLengthBetweenEqualCharacters(s));
    }

    @Test
    public void example2() {
        String s = "abca";
        int expected = 2;
        Assertions.assertEquals(expected, solution1624.maxLengthBetweenEqualCharacters(s));
    }

    @Test
    public void example3() {
        String s = "cbzxy";
        int expected = -1;
        Assertions.assertEquals(expected, solution1624.maxLengthBetweenEqualCharacters(s));
    }

    @Test
    public void example4() {
        String s = "cabbac";
        int expected = 4;
        Assertions.assertEquals(expected, solution1624.maxLengthBetweenEqualCharacters(s));
    }
}
