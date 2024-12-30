import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1456Tests {
    private final Solution1456 solution1456 = new Solution1456();

    @Test
    public void example1() {
        String s = "abciiidef";
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution1456.maxVowels(s, k));
    }

    @Test
    public void example2() {
        String s = "aeiou";
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution1456.maxVowels(s, k));
    }

    @Test
    public void example3() {
        String s = "leetcode";
        int k = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution1456.maxVowels(s, k));
    }

    @Test
    public void example4() {
        String s = "rhythms";
        int k = 4;
        int expected = 0;
        Assertions.assertEquals(expected, solution1456.maxVowels(s, k));
    }

    @Test
    public void example5() {
        String s = "tryhard";
        int k = 4;
        int expected = 1;
        Assertions.assertEquals(expected, solution1456.maxVowels(s, k));
    }
}