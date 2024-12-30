import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP245Tests {
    private final SolutionP245 solutionP245 = new SolutionP245();

    @Test
    public void example1() {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "coding";
        int expected = 1;
        Assertions.assertEquals(expected, solutionP245.shortestWordDistance(wordsDict, word1, word2));
    }

    @Test
    public void example2() {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "makes";
        int expected = 3;
        Assertions.assertEquals(expected, solutionP245.shortestWordDistance(wordsDict, word1, word2));
    }
}
