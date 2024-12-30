import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionP267Tests {
    private final SolutionP267 solutionP267 = new SolutionP267();

    @Test
    public void example1() {
        String s = "aabb";
        List<String> expected = Arrays.asList("abba", "baab");
        List<String> actual = solutionP267.generatePalindromes(s);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String s = "abc";
        List<String> expected = Arrays.asList();
        List<String> actual = solutionP267.generatePalindromes(s);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}
