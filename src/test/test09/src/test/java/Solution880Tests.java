import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution880Tests {
    private final Solution880 solution880 = new Solution880();

    @Test
    public void example1() {
        String s = "leet2code3";
        int k = 10;
        String expected = "o";
        Assertions.assertEquals(expected, solution880.decodeAtIndex(s, k));
    }

    @Test
    public void example2() {
        String s = "ha22";
        int k = 5;
        String expected = "h";
        Assertions.assertEquals(expected, solution880.decodeAtIndex(s, k));
    }

    @Test
    public void example3() {
        String s = "a2345678999999999999999";
        int k = 1;
        String expected = "a";
        Assertions.assertEquals(expected, solution880.decodeAtIndex(s, k));
    }
}