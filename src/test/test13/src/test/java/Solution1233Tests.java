import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution1233Tests {
    private final Solution1233 solution1233 = new Solution1233();

    @Test
    public void example1() {
        String[] folder = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        List<String> expected = Arrays.asList("/a", "/c/d", "/c/f");
        List<String> actual = solution1233.removeSubfolders(folder);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String[] folder = {"/a", "/a/b/c", "/a/b/d"};
        List<String> expected = Arrays.asList("/a");
        List<String> actual = solution1233.removeSubfolders(folder);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        String[] folder = {"/a/b/c", "/a/b/ca", "/a/b/d"};
        List<String> expected = Arrays.asList("/a/b/c", "/a/b/ca", "/a/b/d");
        List<String> actual = solution1233.removeSubfolders(folder);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}