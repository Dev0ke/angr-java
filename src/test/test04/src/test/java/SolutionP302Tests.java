import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP302Tests {
    private final SolutionP302.V1 solutionP302_v1 = new SolutionP302.V1();
    private final SolutionP302.V2 solutionP302_v2 = new SolutionP302.V2();

    @Test
    public void example1() {
        char[][] image = UtUtils.stringToChars2("""
                [["0","0","1","0"],["0","1","1","0"],["0","1","0","0"]]
                """);
        int x = 0;
        int y = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solutionP302_v1.minArea(image, x, y));
        Assertions.assertEquals(expected, solutionP302_v2.minArea(image, x, y));
    }

    @Test
    public void example2() {
        char[][] image = UtUtils.stringToChars2("""
                [["1"]]
                """);
        int x = 0;
        int y = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP302_v1.minArea(image, x, y));
        Assertions.assertEquals(expected, solutionP302_v2.minArea(image, x, y));
    }
}