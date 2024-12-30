import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution890Tests {
    private final Solution890 solution890 = new Solution890();

    @Test
    public void example1() {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        List<String> expected = new ArrayList<>(List.of("mee", "aqq"));
        List<String> actual = solution890.findAndReplacePattern(words, pattern);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}