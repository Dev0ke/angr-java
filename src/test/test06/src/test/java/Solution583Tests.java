import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution583Tests {
    private final Solution583 solution583 = new Solution583();

    @Test
    public void example1() {
        String word1 = "sea";
        String word2 = "eat";
        int expected = 2;
        Assertions.assertEquals(expected, solution583.minDistance(word1, word2));
    }
}
