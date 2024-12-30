import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1854Tests {
    private final Solution1854 solution1854 = new Solution1854();

    @Test
    public void example1() {
        int[][] logs = UtUtils.stringToInts2("[[1993,1999],[2000,2010]]");
        int expected = 1993;
        Assertions.assertEquals(expected, solution1854.maximumPopulation(logs));
    }

    @Test
    public void example2() {
        int[][] logs = UtUtils.stringToInts2("[[1950,1961],[1960,1971],[1970,1981]]");
        int expected = 1960;
        Assertions.assertEquals(expected, solution1854.maximumPopulation(logs));
    }
}
