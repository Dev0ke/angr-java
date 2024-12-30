import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1861Tests {
    private final Solution1861 solution1861 = new Solution1861();

    @Test
    public void example1() {
        char[][] box = UtUtils.stringToChars2("""
                [["#",".","#"]]
                """);
        char[][] expected = UtUtils.stringToChars2("""
                [["."],
                ["#"],
                ["#"]]
                """);
        Assertions.assertArrayEquals(expected, solution1861.rotateTheBox(box));
    }

    @Test
    public void example2() {
        char[][] box = UtUtils.stringToChars2("""
                [["#",".","*","."],
                ["#","#","*","."]]
                """);
        char[][] expected = UtUtils.stringToChars2("""
                [["#","."],
                ["#","#"],
                ["*","*"],
                [".","."]]
                """);
        Assertions.assertArrayEquals(expected, solution1861.rotateTheBox(box));
    }

    @Test
    public void example3() {
        char[][] box = UtUtils.stringToChars2("""
                [["#","#","*",".","*","."],
                ["#","#","#","*",".","."],
                ["#","#","#",".","#","."]]
                """);
        char[][] expected = UtUtils.stringToChars2("""
                [[".","#","#"],
                [".","#","#"],
                ["#","#","*"],
                ["#","*","."],
                ["#",".","*"],
                ["#",".","."]]
                """);
        Assertions.assertArrayEquals(expected, solution1861.rotateTheBox(box));
    }
}