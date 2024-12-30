import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution212Tests {
    private final Solution212 solution212 = new Solution212();

    @Test
    public void example1() {
        char[][] board = UtUtils.stringToChars2("""
                [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
                """);
        String[] words = {"oath", "pea", "eat", "rain"};
//        List<String> expected = Arrays.asList("eat", "oath");
        List<String> expected = Arrays.asList("oath", "eat");
        Assertions.assertEquals(expected, solution212.findWords(board, words));
    }

    @Test
    public void example2() {
        char[][] board = UtUtils.stringToChars2("""
                [["a","b"],["c","d"]]
                """);
        String[] words = {"abcb"};
        List<String> expected = new ArrayList<>();
        Assertions.assertEquals(expected, solution212.findWords(board, words));
    }
}
