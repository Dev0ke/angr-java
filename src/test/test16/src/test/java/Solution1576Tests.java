import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1576Tests {
    private final Solution1576 solution1576 = new Solution1576();

    @Test
    public void example1() {
        String s = "?zs";
        String expected = "azs";
        Assertions.assertTrue(check(s, solution1576.modifyString(s)));
    }

    @Test
    public void example2() {
        String s = "ubv?w";
        String expected = "ubvaw";
        Assertions.assertTrue(check(s, solution1576.modifyString(s)));
    }

    @Test
    public void example3() {
        String s = "j?qg??b";
        String expected = "jaqgacb";
        Assertions.assertTrue(check(s, solution1576.modifyString(s)));
    }

    @Test
    public void example4() {
        String s = "??yw?ipkj?";
        String expected = "acywaipkja";
        Assertions.assertTrue(check(s, solution1576.modifyString(s)));
    }

    private boolean check(String s, String actual) {
        int len = s.length();
        if (actual.length() != len) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != '?' && s.charAt(i) != actual.charAt(i)) {
                return false;
            }
        }
        for (int i = 1; i < len; i++) {
            if (actual.charAt(i) == actual.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
