import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1307Tests {
    private final Solution1307 solution1307 = new Solution1307();

    @Test
    public void example1() {
        String[] words = {"SEND", "MORE"};
        String result = "MONEY";
        Assertions.assertTrue(solution1307.isSolvable(words, result));
    }

    @Test
    public void example2() {
        String[] words = {"SIX", "SEVEN", "SEVEN"};
        String result = "TWENTY";
        Assertions.assertTrue(solution1307.isSolvable(words, result));
    }

    @Test
    public void example3() {
        String[] words = {"THIS", "IS", "TOO"};
        String result = "FUNNY";
        Assertions.assertTrue(solution1307.isSolvable(words, result));
    }

    @Test
    public void example4() {
        String[] words = {"LEET", "CODE"};
        String result = "POINT";
        Assertions.assertFalse(solution1307.isSolvable(words, result));
    }
}