import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1156Tests {
    private final Solution1156 solution1156 = new Solution1156();

    @Test
    public void example1() {
        String text = "ababa";
        int expected = 3;
        Assertions.assertEquals(expected, solution1156.maxRepOpt1(text));
    }

    @Test
    public void example2() {
        String text = "aaabaaa";
        int expected = 6;
        Assertions.assertEquals(expected, solution1156.maxRepOpt1(text));
    }

    @Test
    public void example3() {
        String text = "aaabbaaa";
        int expected = 4;
        Assertions.assertEquals(expected, solution1156.maxRepOpt1(text));
    }

    @Test
    public void example4() {
        String text = "aaaaa";
        int expected = 5;
        Assertions.assertEquals(expected, solution1156.maxRepOpt1(text));
    }

    @Test
    public void example5() {
        String text = "abcdef";
        int expected = 1;
        Assertions.assertEquals(expected, solution1156.maxRepOpt1(text));
    }
}