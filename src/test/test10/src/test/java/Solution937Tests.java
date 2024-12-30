import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution937Tests {
    private final Solution937 solution937 = new Solution937();

    @Test
    public void example1() {
        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] expected = {"let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"};
        Assertions.assertArrayEquals(expected, solution937.reorderLogFiles(logs));
    }

    @Test
    public void example2() {
        String[] logs = {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
        String[] expected = {"g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"};
        Assertions.assertArrayEquals(expected, solution937.reorderLogFiles(logs));
    }
}