import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1657Tests {
    private final Solution1657 solution1657 = new Solution1657();

    @Test
    public void example1() {
        String word1 = "abc";
        String word2 = "bca";
        Assertions.assertTrue(solution1657.closeStrings(word1, word2));
    }

    @Test
    public void example2() {
        String word1 = "a";
        String word2 = "aa";
        Assertions.assertFalse(solution1657.closeStrings(word1, word2));
    }

    @Test
    public void example3() {
        String word1 = "cabbba";
        String word2 = "abbccc";
        Assertions.assertTrue(solution1657.closeStrings(word1, word2));
    }

    @Test
    public void example4() {
        String word1 = "cabbba";
        String word2 = "aabbss";
        Assertions.assertFalse(solution1657.closeStrings(word1, word2));
    }
}