import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1366Tests {
    private final Solution1366 solution1366 = new Solution1366();

    @Test
    public void example1() {
        String[] votes = {"ABC", "ACB", "ABC", "ACB", "ACB"};
        String expected = "ACB";
        Assertions.assertEquals(expected, solution1366.rankTeams(votes));
    }

    @Test
    public void example2() {
        String[] votes = {"WXYZ", "XYZW"};
        String expected = "XWYZ";
        Assertions.assertEquals(expected, solution1366.rankTeams(votes));
    }

    @Test
    public void example3() {
        String[] votes = {"ZMNAGUEDSJYLBOPHRQICWFXTVK"};
        String expected = "ZMNAGUEDSJYLBOPHRQICWFXTVK";
        Assertions.assertEquals(expected, solution1366.rankTeams(votes));
    }

    @Test
    public void example4() {
        String[] votes = {"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"};
        String expected = "ABC";
        Assertions.assertEquals(expected, solution1366.rankTeams(votes));
    }

    @Test
    public void example5() {
        String[] votes = {"M", "M", "M", "M"};
        String expected = "M";
        Assertions.assertEquals(expected, solution1366.rankTeams(votes));
    }
}
