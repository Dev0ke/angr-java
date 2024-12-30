import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1773Tests {
    private final Solution1773 solution1773 = new Solution1773();

    @Test
    public void example1() {
        List<List<String>> items = UtUtils.stringToStringList2("""
                [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]]
                """);
        String ruleKey = "color";
        String ruleValue = "silver";
        int expected = 1;
        Assertions.assertEquals(expected, solution1773.countMatches(items, ruleKey, ruleValue));
    }

    @Test
    public void example2() {
        List<List<String>> items = UtUtils.stringToStringList2("""
                [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]]
                """);
        String ruleKey = "type";
        String ruleValue = "phone";
        int expected = 2;
        Assertions.assertEquals(expected, solution1773.countMatches(items, ruleKey, ruleValue));
    }
}
