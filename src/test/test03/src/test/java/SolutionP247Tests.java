import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionP247Tests {
    private final SolutionP247 solutionP247 = new SolutionP247();

    @Test
    public void example1() {
        int n = 2;
        List<String> expected = new ArrayList<>(List.of("11", "69", "88", "96"));
        List<String> actual = solutionP247.findStrobogrammatic(n);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    // 补充用例
    @Test
    public void example2() {
        int n = 1;
        List<String> expected = new ArrayList<>(List.of("0", "1", "8"));
        List<String> actual = solutionP247.findStrobogrammatic(n);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        int n = 3;
        List<String> expected = new ArrayList<>(List.of("101", "808", "609", "906", "111", "818", "619", "916", "181", "888", "689", "986"));
        List<String> actual = solutionP247.findStrobogrammatic(n);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}