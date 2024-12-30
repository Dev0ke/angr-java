import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution71Tests {
    private final Solution71 solution71 = new Solution71();

    @Test
    public void example1() {
        String path = "/home/";
        String expected = "/home";
        Assertions.assertEquals(expected, solution71.simplifyPath(path));
    }

    @Test
    public void example2() {
        String path = "/../";
        String expected = "/";
        Assertions.assertEquals(expected, solution71.simplifyPath(path));
    }

    @Test
    public void example3() {
        String path = "/home//foo/";
        String expected = "/home/foo";
        Assertions.assertEquals(expected, solution71.simplifyPath(path));
    }

    @Test
    public void example4() {
        String path = "/a/./b/../../c/";
        String expected = "/c";
        Assertions.assertEquals(expected, solution71.simplifyPath(path));
    }
}
