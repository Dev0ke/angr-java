import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution17Tests {
    private final Solution17 solution17 = new Solution17();

    @Test
    public void example1() {
        String digits = "23";
        List<String> expected = List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        Assertions.assertEquals(expected, solution17.letterCombinations(digits));
    }

    @Test
    public void example2() {
        String digits = "";
        List<String> expected = new ArrayList<>();
        Assertions.assertEquals(expected, solution17.letterCombinations(digits));
    }

    @Test
    public void example3() {
        String digits = "2";
        List<String> expected = List.of("a", "b", "c");
        Assertions.assertEquals(expected, solution17.letterCombinations(digits));
    }
}
