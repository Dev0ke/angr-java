import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Solution2456Tests {
    private final Solution2456 solution2456 = new Solution2456();

    public static final Comparator<List<String>> STRING_LIST_COMPARATOR = (o1, o2) -> {
        // o1.size() != o2.size();
        int minLen = Math.min(o1.size(), o2.size());
        for (int i = 0; i < minLen; i++) {
            if (!Objects.equals(o1.get(i), o2.get(i))) {
                return o1.get(i).compareTo(o2.get(i));
            }
        }
        return o1.size() - o2.size();
    };

    @Test
    public void example1() {
        String[] creators = {"alice", "bob", "alice", "chris"};
        String[] ids = {"one", "two", "three", "four"};
        int[] views = {5, 10, 5, 4};
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["alice","one"],["bob","two"]]
                """);
        List<List<String>> actual = solution2456.mostPopularCreator(creators, ids, views);
        expected.sort(STRING_LIST_COMPARATOR);
        actual.sort(STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String[] creators = {"alice", "alice", "alice"};
        String[] ids = {"a", "b", "c"};
        int[] views = {1, 2, 2};
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["alice","b"]]
                """);
        List<List<String>> actual = solution2456.mostPopularCreator(creators, ids, views);
        expected.sort(STRING_LIST_COMPARATOR);
        actual.sort(STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/377703493/
        // 81 / 82 个通过测试用例
        final String fileName = "solution2456-example3-input.txt";
        String[] creators = UtUtils.loadingStrings(fileName, 0);
        String[] ids = UtUtils.loadingStrings(fileName, 1);
        int[] views = UtUtils.loadingInts(fileName, 2);
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["l", "vy"]]
                """);
        List<List<String>> actual = solution2456.mostPopularCreator(creators, ids, views);
        expected.sort(STRING_LIST_COMPARATOR);
        actual.sort(STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
