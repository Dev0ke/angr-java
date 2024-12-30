import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP734Tests {
    private final SolutionP734 solutionP734 = new SolutionP734();

    @Test
    public void example1() {
        String[] sentence1 = {"great", "acting", "skills"};
        String[] sentence2 = {"fine", "drama", "talent"};
        List<List<String>> similarPairs = UtUtils.stringToStringList2("""
                [["great","fine"],["drama","acting"],["skills","talent"]]
                """);
        Assertions.assertTrue(solutionP734.areSentencesSimilar(sentence1, sentence2, similarPairs));
    }

    @Test
    public void example2() {
        String[] sentence1 = {"great"};
        String[] sentence2 = {"great"};
        List<List<String>> similarPairs = UtUtils.stringToStringList2("""
                []
                """);
        Assertions.assertTrue(solutionP734.areSentencesSimilar(sentence1, sentence2, similarPairs));
    }

    @Test
    public void example3() {
        String[] sentence1 = {"great"};
        String[] sentence2 = {"doubleplus", "good"};
        List<List<String>> similarPairs = UtUtils.stringToStringList2("""
                [["great","doubleplus"]]
                """);
        Assertions.assertFalse(solutionP734.areSentencesSimilar(sentence1, sentence2, similarPairs));
    }
}