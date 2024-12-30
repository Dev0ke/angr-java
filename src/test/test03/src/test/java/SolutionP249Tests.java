import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP249Tests {
    private final SolutionP249 solutionP249 = new SolutionP249();

    @Test
    public void example1() {
        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [
                  ["abc","bcd","xyz"],
                  ["az","ba"],
                  ["acef"],
                  ["a","z"]
                ]
                """);
        List<List<String>> actual = solutionP249.groupStrings(strings);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
