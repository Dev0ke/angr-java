import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3324Tests {
    private final Solution3324 solution3324 = new Solution3324();

    @Test
    public void example1() {
        String target = "abc";
        List<String> expected = List.of("a", "aa", "ab", "aba", "abb", "abc");
        Assertions.assertEquals(expected, solution3324.stringSequence(target));
    }

    @Test
    public void example2() {
        String target = "he";
        List<String> expected = List.of("a", "b", "c", "d", "e", "f", "g", "h", "ha", "hb", "hc", "hd", "he");
        Assertions.assertEquals(expected, solution3324.stringSequence(target));
    }
}