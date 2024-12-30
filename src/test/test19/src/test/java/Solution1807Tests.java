import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1807Tests {
    private final Solution1807 solution1807 = new Solution1807();

    @Test
    public void example1() {
        String s = "(name)is(age)yearsold";
        List<List<String>> knowledge = UtUtils.stringToStringList2("""
                [["name","bob"],["age","two"]]
                """);
        String expected = "bobistwoyearsold";
        Assertions.assertEquals(expected, solution1807.evaluate(s, knowledge));
    }

    @Test
    public void example2() {
        String s = "hi(name)";
        List<List<String>> knowledge = UtUtils.stringToStringList2("""
                [["a","b"]]
                """);
        String expected = "hi?";
        Assertions.assertEquals(expected, solution1807.evaluate(s, knowledge));
    }

    @Test
    public void example3() {
        String s = "(a)(a)(a)aaa";
        List<List<String>> knowledge = UtUtils.stringToStringList2("""
                [["a","yes"]]
                """);
        String expected = "yesyesyesaaa";
        Assertions.assertEquals(expected, solution1807.evaluate(s, knowledge));
    }
}
