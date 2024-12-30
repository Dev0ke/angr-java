import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP2814Tests {
    private final SolutionP2814 solutionP2814 = new SolutionP2814();

    @Test
    public void example1() {
        List<List<String>> land = UtUtils.stringToStringList2("""
                [["D",".","*"],[".",".","."],[".","S","."]]
                """);
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2814.minimumSeconds(land));
    }

    @Test
    public void example2() {
        List<List<String>> land = UtUtils.stringToStringList2("""
                [["D","X","*"],[".",".","."],[".",".","S"]]
                """);
        int expected = -1;
        Assertions.assertEquals(expected, solutionP2814.minimumSeconds(land));
    }

    @Test
    public void example3() {
        List<List<String>> land = UtUtils.stringToStringList2("""
                [["D",".",".",".","*","."],[".","X",".","X",".","."],[".",".",".",".","S","."]]
                """);
        int expected = 6;
        Assertions.assertEquals(expected, solutionP2814.minimumSeconds(land));
    }
}