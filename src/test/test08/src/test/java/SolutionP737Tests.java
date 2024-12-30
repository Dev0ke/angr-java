import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP737Tests {
    private final SolutionP737 solutionP737 = new SolutionP737();

    @Test
    public void example1() {
        String[] sentence1 = {"great", "acting", "skills"};
        String[] sentence2 = {"fine", "drama", "talent"};
        List<List<String>> similarPairs = UtUtils.stringToStringList2("""
                [["great","good"],["fine","good"],["drama","acting"],["skills","talent"]]
                """);
        Assertions.assertTrue(solutionP737.areSentencesSimilarTwo(sentence1, sentence2, similarPairs));
    }

    @Test
    public void example2() {
        String[] sentence1 = {"I", "love", "leetcode"};
        String[] sentence2 = {"I", "love", "onepiece"};
        List<List<String>> similarPairs = UtUtils.stringToStringList2("""
                [["manga","onepiece"],["platform","anime"],["leetcode","platform"],["anime","manga"]]
                """);
        Assertions.assertTrue(solutionP737.areSentencesSimilarTwo(sentence1, sentence2, similarPairs));
    }

    @Test
    public void example3() {
        String[] sentence1 = {"I", "love", "leetcode"};
        String[] sentence2 = {"I", "love", "onepiece"};
        List<List<String>> similarPairs = UtUtils.stringToStringList2("""
                [["manga","hunterXhunter"],["platform","anime"],["leetcode","platform"],["anime","manga"]]
                """);
        Assertions.assertFalse(solutionP737.areSentencesSimilarTwo(sentence1, sentence2, similarPairs));
    }
}
