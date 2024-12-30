import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1065Tests {
    private final SolutionP1065 solutionP1065 = new SolutionP1065();

    @Test
    public void example1() {
        String text = "thestoryofleetcodeandme";
        String[] words = {"story", "fleet", "leetcode"};
        int[][] expected = UtUtils.stringToInts2("[[3,7],[9,13],[10,17]]");
        Assertions.assertArrayEquals(expected, solutionP1065.indexPairs(text, words));
    }

    @Test
    public void example2() {
        String text = "ababa";
        String[] words = {"aba", "ab"};
        int[][] expected = UtUtils.stringToInts2("[[0,1],[0,2],[2,3],[2,4]]");
        Assertions.assertArrayEquals(expected, solutionP1065.indexPairs(text, words));
    }
}
