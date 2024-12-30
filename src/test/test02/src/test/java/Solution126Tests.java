import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution126Tests {
    private final Solution126 solution126 = new Solution126();

    @Test
    public void example1() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log", "cog"));
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
                """);
        Assertions.assertEquals(expected, solution126.findLadders(beginWord, endWord, wordList));
    }

    @Test
    public void example2() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log"));
        List<List<String>> expected = UtUtils.stringToStringList2("[]");
        Assertions.assertEquals(expected, solution126.findLadders(beginWord, endWord, wordList));
    }

    // 补充用例
    @Test
    public void example3() {
        String fileName = "solution126-example3-input.txt";
        String beginWord = UtUtils.loadingString(fileName, 0);
        String endWord = UtUtils.loadingString(fileName, 1);
        List<String> wordList = UtUtils.loadingStringList(fileName, 2);
        List<List<String>> expected = UtUtils.stringToStringList2("[]");
        Assertions.assertEquals(expected, solution126.findLadders(beginWord, endWord, wordList));
    }
}
