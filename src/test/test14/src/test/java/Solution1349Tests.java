import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1349Tests {
    private final Solution1349 solution1349 = new Solution1349();

    @Test
    public void example1() {
        char[][] seats = UtUtils.stringToChars2("""
                [["#",".","#","#",".","#"],
                [".","#","#","#","#","."],
                ["#",".","#","#",".","#"]]
                """);
        int expected = 4;
        Assertions.assertEquals(expected, solution1349.maxStudents(seats));
    }

    @Test
    public void example2() {
        char[][] seats = UtUtils.stringToChars2("""
                [[".","#"],
                ["#","#"],
                ["#","."],
                ["#","#"],
                [".","#"]]
                """);
        int expected = 3;
        Assertions.assertEquals(expected, solution1349.maxStudents(seats));
    }

    @Test
    public void example3() {
        char[][] seats = UtUtils.stringToChars2("""
                [["#",".",".",".","#"],
                [".","#",".","#","."],
                [".",".","#",".","."],
                [".","#",".","#","."],
                ["#",".",".",".","#"]]
                """);
        int expected = 10;
        Assertions.assertEquals(expected, solution1349.maxStudents(seats));
    }
}