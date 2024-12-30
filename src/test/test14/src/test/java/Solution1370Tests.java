import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1370Tests {
    private final Solution1370 solution1370 = new Solution1370();

    @Test
    public void example1() {
        String s = "aaaabbbbcccc";
        String expected = "abccbaabccba";
        Assertions.assertEquals(expected, solution1370.sortString(s));
    }

    @Test
    public void example2() {
        String s = "rat";
        String expected = "art";
        Assertions.assertEquals(expected, solution1370.sortString(s));
    }

    @Test
    public void example3() {
        String s = "leetcode";
        String expected = "cdelotee";
        Assertions.assertEquals(expected, solution1370.sortString(s));
    }

    @Test
    public void example4() {
        String s = "ggggggg";
        String expected = "ggggggg";
        Assertions.assertEquals(expected, solution1370.sortString(s));
    }

    @Test
    public void example5() {
        String s = "spo";
        String expected = "ops";
        Assertions.assertEquals(expected, solution1370.sortString(s));
    }
}