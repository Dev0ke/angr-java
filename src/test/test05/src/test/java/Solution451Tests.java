import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class Solution451Tests {
    private final Solution451 solution451 = new Solution451();

    @Test
    public void example1() {
        String s = "tree";
        String expected = "eert";
        Assertions.assertEquals(expected, solution451.frequencySort(s));
    }

    @Test
    public void example2() {
        String s = "cccaaa";
        String expected = "cccaaa";
        Set<String> expectedSet = Set.of("cccaaa", "aaaccc");
        Assertions.assertTrue(expectedSet.contains(solution451.frequencySort(s)));
    }

    @Test
    public void example3() {
        String s = "Aabb";
        String expected = "bbAa";
        Set<String> expectedSet = Set.of("bbAa", "bbaA");
        Assertions.assertTrue(expectedSet.contains(solution451.frequencySort(s)));
    }
}
