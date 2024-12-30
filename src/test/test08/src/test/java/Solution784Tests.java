import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution784Tests {
    private final Solution784 solution784 = new Solution784();

    @Test
    public void example1() {
        String s = "a1b2";
        List<String> expected = Arrays.asList("a1b2", "a1B2", "A1b2", "A1B2");
        List<String> actual = solution784.letterCasePermutation(s);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String s = "3z4";
        List<String> expected = Arrays.asList("3z4", "3Z4");
        List<String> actual = solution784.letterCasePermutation(s);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}
