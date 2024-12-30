import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1880Tests {
    private final Solution1880 solution1880 = new Solution1880();

    @Test
    public void example1() {
        String firstWord = "acb";
        String secondWord = "cba";
        String targetWord = "cdb";
        Assertions.assertTrue(solution1880.isSumEqual(firstWord, secondWord, targetWord));
    }

    @Test
    public void example2() {
        String firstWord = "aaa";
        String secondWord = "a";
        String targetWord = "aab";
        Assertions.assertFalse(solution1880.isSumEqual(firstWord, secondWord, targetWord));
    }

    @Test
    public void example3() {
        String firstWord = "aaa";
        String secondWord = "a";
        String targetWord = "aaaa";
        Assertions.assertTrue(solution1880.isSumEqual(firstWord, secondWord, targetWord));
    }
}
