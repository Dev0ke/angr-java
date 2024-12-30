import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution68Tests {
    private final Solution68 solution68 = new Solution68();

    @Test
    public void example1() {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> expected = List.of(
                "This    is    an",
                "example  of text",
                "justification.  "
        );
        Assertions.assertEquals(expected, solution68.fullJustify(words, maxWidth));
    }

    @Test
    public void example2() {
        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth = 16;
        List<String> expected = List.of(
                "What   must   be",
                "acknowledgment  ",
                "shall be        "
        );
        Assertions.assertEquals(expected, solution68.fullJustify(words, maxWidth));
    }

    @Test
    public void example3() {
        String[] words = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth = 20;
        List<String> expected = List.of(
                "Science  is  what we",
                "understand      well",
                "enough to explain to",
                "a  computer.  Art is",
                "everything  else  we",
                "do                  "
        );
        Assertions.assertEquals(expected, solution68.fullJustify(words, maxWidth));
    }
}
