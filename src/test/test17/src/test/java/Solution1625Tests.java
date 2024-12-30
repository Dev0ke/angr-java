import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1625Tests {
    private final Solution1625 solution1625 = new Solution1625();

    @Test
    public void example1() {
        String s = "5525";
        int a = 9;
        int b = 2;
        String expected = "2050";
        Assertions.assertEquals(expected, solution1625.findLexSmallestString(s, a, b));
    }

    @Test
    public void example2() {
        String s = "74";
        int a = 5;
        int b = 1;
        String expected = "24";
        Assertions.assertEquals(expected, solution1625.findLexSmallestString(s, a, b));
    }

    @Test
    public void example3() {
        String s = "0011";
        int a = 4;
        int b = 2;
        String expected = "0011";
        Assertions.assertEquals(expected, solution1625.findLexSmallestString(s, a, b));
    }

    @Test
    public void example4() {
        String s = "43987654";
        int a = 7;
        int b = 3;
        String expected = "00553311";
        Assertions.assertEquals(expected, solution1625.findLexSmallestString(s, a, b));
    }
}