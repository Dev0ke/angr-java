import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1948Tests {
    private final Solution1948 solution1948 = new Solution1948();

    @Test
    public void example1() {
        List<List<String>> paths = UtUtils.stringToStringList2("""
                [["a"],["c"],["d"],["a","b"],["c","b"],["d","a"]]
                """);
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["d"],["d","a"]]
                """);
        List<List<String>> actual = solution1948.deleteDuplicateFolder(paths);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        List<List<String>> paths = UtUtils.stringToStringList2("""
                [["a"],["c"],["a","b"],["c","b"],["a","b","x"],["a","b","x","y"],["w"],["w","y"]]
                """);
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["c"],["c","b"],["a"],["a","b"]]
                """);
        List<List<String>> actual = solution1948.deleteDuplicateFolder(paths);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        List<List<String>> paths = UtUtils.stringToStringList2("""
                [["a","b"],["c","d"],["c"],["a"]]
                """);
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["c"],["c","d"],["a"],["a","b"]]
                """);
        List<List<String>> actual = solution1948.deleteDuplicateFolder(paths);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example4() {
        List<List<String>> paths = UtUtils.stringToStringList2("""
                [["a"],["a","x"],["a","x","y"],["a","z"],["b"],["b","x"],["b","x","y"],["b","z"]]
                """);
        List<List<String>> expected = UtUtils.stringToStringList2("""
                []
                """);
        List<List<String>> actual = solution1948.deleteDuplicateFolder(paths);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example5() {
        List<List<String>> paths = UtUtils.stringToStringList2("""
                [["a"],["a","x"],["a","x","y"],["a","z"],["b"],["b","x"],["b","x","y"],["b","z"],["b","w"]]
                """);
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["b"],["b","w"],["b","z"],["a"],["a","z"]]
                """);
        List<List<String>> actual = solution1948.deleteDuplicateFolder(paths);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}