import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution809Tests {
    private final Solution809 solution809 = new Solution809();

    @Test
    public void example1() {
        String s = "heeellooo";
        String[] words = {"hello", "hi", "helo"};
        int expected = 1;
        Assertions.assertEquals(expected, solution809.expressiveWords(s, words));
    }
}