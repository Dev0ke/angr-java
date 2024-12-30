import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1397Tests {
    private final Solution1397 solution1397 = new Solution1397();

    @Test
    public void example1() {
        int n = 2;
        String s1 = "aa";
        String s2 = "da";
        String evil = "b";
        int expected = 51;
        Assertions.assertEquals(expected, solution1397.findGoodStrings(n, s1, s2, evil));
    }

    @Test
    public void example2() {
        int n = 8;
        String s1 = "leetcode";
        String s2 = "leetgoes";
        String evil = "leet";
        int expected = 0;
        Assertions.assertEquals(expected, solution1397.findGoodStrings(n, s1, s2, evil));
    }

    @Test
    public void example3() {
        int n = 2;
        String s1 = "gx";
        String s2 = "gz";
        String evil = "x";
        int expected = 2;
        Assertions.assertEquals(expected, solution1397.findGoodStrings(n, s1, s2, evil));
    }
}
