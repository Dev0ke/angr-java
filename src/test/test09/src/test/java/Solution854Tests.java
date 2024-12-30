import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution854Tests {
    private final Solution854 solution854 = new Solution854();

    @Test
    public void example1() {
        String s1 = "ab";
        String s2 = "ba";
        int expected = 1;
        Assertions.assertEquals(expected, solution854.kSimilarity(s1, s2));
    }

    @Test
    public void example2() {
        String s1 = "abc";
        String s2 = "bca";
        int expected = 2;
        Assertions.assertEquals(expected, solution854.kSimilarity(s1, s2));
    }
}