import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3093Tests {
    private final Solution3093 solution3093 = new Solution3093();

    @Test
    public void example1() {
        String[] wordsContainer = {"abcd", "bcd", "xbcd"};
        String[] wordsQuery = {"cd", "bcd", "xyz"};
        int[] expected = {1, 1, 1};
        Assertions.assertArrayEquals(expected, solution3093.stringIndices(wordsContainer, wordsQuery));
    }

    @Test
    public void example2() {
        String[] wordsContainer = {"abcdefgh", "poiuygh", "ghghgh"};
        String[] wordsQuery = {"gh", "acbfgh", "acbfegh"};
        int[] expected = {2, 0, 2};
        Assertions.assertArrayEquals(expected, solution3093.stringIndices(wordsContainer, wordsQuery));
    }
}