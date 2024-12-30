import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1255Tests {
    private final Solution1255 solution1255 = new Solution1255();

    @Test
    public void example1() {
        String[] words = {"dog", "cat", "dad", "good"};
        char[] letters = UtUtils.stringToChars("""
                ["a","a","c","d","d","d","g","o","o"]
                """);
        int[] score = {1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int expected = 23;
        Assertions.assertEquals(expected, solution1255.maxScoreWords(words, letters, score));
    }

    @Test
    public void example2() {
        String[] words = {"xxxz", "ax", "bx", "cx"};
        char[] letters = UtUtils.stringToChars("""
                ["z","a","b","c","x","x","x"]
                """);
        int[] score = {4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10};
        int expected = 27;
        Assertions.assertEquals(expected, solution1255.maxScoreWords(words, letters, score));
    }

    @Test
    public void example3() {
        String[] words = {"leetcode"};
        char[] letters = UtUtils.stringToChars("""
                ["l","e","t","c","o","d"]
                """);
        int[] score = {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0};
        int expected = 0;
        Assertions.assertEquals(expected, solution1255.maxScoreWords(words, letters, score));
    }
}