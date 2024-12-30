import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2301Tests {
    private final Solution2301.V1 solution2301_v1 = new Solution2301.V1();
    private final Solution2301.V2 solution2301_v2 = new Solution2301.V2();

    @Test
    public void example1() {
        String s = "fool3e7bar";
        String sub = "leet";
        char[][] mappings = UtUtils.stringToChars2("""
                [["e","3"],["t","7"],["t","8"]]
                """);
        Assertions.assertTrue(solution2301_v1.matchReplacement(s, sub, mappings));
        Assertions.assertTrue(solution2301_v2.matchReplacement(s, sub, mappings));
    }

    @Test
    public void example2() {
        String s = "fooleetbar";
        String sub = "f00l";
        char[][] mappings = UtUtils.stringToChars2("""
                [["o","0"]]
                """);
        Assertions.assertFalse(solution2301_v1.matchReplacement(s, sub, mappings));
        Assertions.assertFalse(solution2301_v2.matchReplacement(s, sub, mappings));
    }

    @Test
    public void example3() {
        String s = "Fool33tbaR";
        String sub = "leetd";
        char[][] mappings = UtUtils.stringToChars2("""
                [["e","3"],["t","7"],["t","8"],["d","b"],["p","b"]]
                 """);
        Assertions.assertTrue(solution2301_v1.matchReplacement(s, sub, mappings));
        Assertions.assertTrue(solution2301_v2.matchReplacement(s, sub, mappings));
    }
}
