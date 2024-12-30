import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution72Tests {
    private final Solution72 solution72 = new Solution72();

    @Test
    public void example1() {
        String word1 = "horse";
        String word2 = "ros";
        int expected = 3;
        Assertions.assertEquals(expected, solution72.minDistance(word1, word2));
    }

    @Test
    public void example2() {
        String word1 = "intention";
        String word2 = "execution";
        int expected = 5;
        Assertions.assertEquals(expected, solution72.minDistance(word1, word2));
    }
}
