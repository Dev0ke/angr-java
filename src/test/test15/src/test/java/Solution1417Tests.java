import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1417Tests {
    private final Solution1417 solution1417 = new Solution1417();

    @Test
    public void example1() {
        String s = "a0b1c2";
        String expected = "0a1b2c";
        Assertions.assertEquals(expected, solution1417.reformat(s));
    }

    @Test
    public void example2() {
        String s = "leetcode";
        String expected = "";
        Assertions.assertEquals(expected, solution1417.reformat(s));
    }

    @Test
    public void example3() {
        String s = "1229857369";
        String expected = "";
        Assertions.assertEquals(expected, solution1417.reformat(s));
    }

    @Test
    public void example4() {
        String s = "covid2019";
        String expected = "c2o0v1i9d";
        Assertions.assertEquals(expected, solution1417.reformat(s));
    }

    @Test
    public void example5() {
        String s = "ab123";
        String expected = "1a2b3";
        Assertions.assertEquals(expected, solution1417.reformat(s));
    }
}
