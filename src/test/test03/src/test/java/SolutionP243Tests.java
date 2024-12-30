import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP243Tests {
    private final SolutionP243 solutionP243 = new SolutionP243();

    @Test
    public void example1() {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";
        int expected = 3;
        Assertions.assertEquals(expected, solutionP243.shortestDistance(wordsDict, word1, word2));
    }

    @Test
    public void example2() {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "coding";
        int expected = 1;
        Assertions.assertEquals(expected, solutionP243.shortestDistance(wordsDict, word1, word2));
    }
}
