import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP425Tests {
    private final SolutionP425 solutionP425 = new SolutionP425();

    @Test
    public void example1() {
        String[] words = {"area", "lead", "wall", "lady", "ball"};
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["ball","area","lead","lady"],
                ["wall","area","lead","lady"]]
                """);
        List<List<String>> actual = solutionP425.wordSquares(words);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String[] words = {"abat", "baba", "atan", "atal"};
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["baba","abat","baba","atal"],
                ["baba","abat","baba","atan"]]
                """);
        List<List<String>> actual = solutionP425.wordSquares(words);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
