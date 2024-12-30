import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution187Tests {
    private final Solution187 solution187 = new Solution187();

    @Test
    public void example1() {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> expected = new ArrayList<>(List.of("AAAAACCCCC", "CCCCCAAAAA"));
        List<String> actual = solution187.findRepeatedDnaSequences(s);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String s = "AAAAAAAAAAAAA";
        List<String> expected = new ArrayList<>(List.of("AAAAAAAAAA"));
        List<String> actual = solution187.findRepeatedDnaSequences(s);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}
