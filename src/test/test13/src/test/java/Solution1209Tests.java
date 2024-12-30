import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1209Tests {
    private final Solution1209 solution1209 = new Solution1209();

    @Test
    public void example1() {
        String s = "abcd";
        int k = 2;
        String expected = "abcd";
        Assertions.assertEquals(expected, solution1209.removeDuplicates(s, k));
    }

    @Test
    public void example2() {
        String s = "deeedbbcccbdaa";
        int k = 3;
        String expected = "aa";
        Assertions.assertEquals(expected, solution1209.removeDuplicates(s, k));
    }

    @Test
    public void example3() {
        String s = "pbbcggttciiippooaais";
        int k = 2;
        String expected = "ps";
        Assertions.assertEquals(expected, solution1209.removeDuplicates(s, k));
    }
}