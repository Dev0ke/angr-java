import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution127Tests {
    private final Solution127 solution127 = new Solution127();

    @Test
    public void example1() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log", "cog"));
        int expected = 5;
        Assertions.assertEquals(expected, solution127.ladderLength(beginWord, endWord, wordList));
    }

    @Test
    public void example2() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log"));
        int expected = 0;
        Assertions.assertEquals(expected, solution127.ladderLength(beginWord, endWord, wordList));
    }
}
