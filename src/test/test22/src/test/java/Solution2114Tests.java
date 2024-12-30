import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2114Tests {
    private final Solution2114 solution2114 = new Solution2114();

    @Test
    public void example1() {
        String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        int expected = 6;
        Assertions.assertEquals(expected, solution2114.mostWordsFound(sentences));
    }

    @Test
    public void example2() {
        String[] sentences = {"please wait", "continue to fight", "continue to win"};
        int expected = 3;
        Assertions.assertEquals(expected, solution2114.mostWordsFound(sentences));
    }
}
