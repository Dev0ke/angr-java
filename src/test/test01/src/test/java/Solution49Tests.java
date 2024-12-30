import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution49Tests {
    private final Solution49 solution49 = new Solution49();

    @Test
    public void example1() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["bat"],["nat","tan"],["ate","eat","tea"]]
                """);
        List<List<String>> actual = solution49.groupAnagrams(strs);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String[] strs = {""};
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [[""]]
                """);
        List<List<String>> actual = solution49.groupAnagrams(strs);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        String[] strs = {"a"};
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["a"]]
                """);
        List<List<String>> actual = solution49.groupAnagrams(strs);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
