import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution205Tests {
    private final Solution205 solution205 = new Solution205();

    @Test
    public void example1() {
        String s = "egg";
        String t = "add";
        Assertions.assertTrue(solution205.isIsomorphic(s, t));
    }

    @Test
    public void example2() {
        String s = "foo";
        String t = "bar";
        Assertions.assertFalse(solution205.isIsomorphic(s, t));
    }

    @Test
    public void example3() {
        String s = "paper";
        String t = "title";
        Assertions.assertTrue(solution205.isIsomorphic(s, t));
    }
}
