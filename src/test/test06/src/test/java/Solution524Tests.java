import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution524Tests {
    private final Solution524 solution524 = new Solution524();

    @Test
    public void example1() {
        String s = "abpcplea";
        List<String> dictionary = List.of("ale", "apple", "monkey", "plea");
        String expected = "apple";
        Assertions.assertEquals(expected, solution524.findLongestWord(s, dictionary));
    }

    @Test
    public void example2() {
        String s = "abpcplea";
        List<String> dictionary = List.of("a", "b", "c");
        String expected = "a";
        Assertions.assertEquals(expected, solution524.findLongestWord(s, dictionary));
    }
}
