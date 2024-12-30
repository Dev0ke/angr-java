import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution2933Tests {
    private final Solution2933 solution2933 = new Solution2933();

    @Test
    public void example1() {
        List<List<String>> access_times = UtUtils.stringToStringList2("""
                [["a","0549"],["b","0457"],["a","0532"],["a","0621"],["b","0540"]]
                """);
        List<String> expected = Arrays.asList("a");
        List<String> actual = solution2933.findHighAccessEmployees(access_times);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        List<List<String>> access_times = UtUtils.stringToStringList2("""
                [["d","0002"],["c","0808"],["c","0829"],["e","0215"],["d","1508"],["d","1444"],["d","1410"],["c","0809"]]
                """);
        List<String> expected = Arrays.asList("c", "d");
        List<String> actual = solution2933.findHighAccessEmployees(access_times);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        List<List<String>> access_times = UtUtils.stringToStringList2("""
                [["cd","1025"],["ab","1025"],["cd","1046"],["cd","1055"],["ab","1124"],["ab","1120"]]
                """);
        List<String> expected = Arrays.asList("ab", "cd");
        List<String> actual = solution2933.findHighAccessEmployees(access_times);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}