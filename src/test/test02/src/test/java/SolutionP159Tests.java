import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP159Tests {
    private final SolutionP159 solutionP159 = new SolutionP159();

    @Test
    public void example1() {
        String s = "eceba";
        int expected = 3;
        Assertions.assertEquals(expected, solutionP159.lengthOfLongestSubstringTwoDistinct(s));
    }

    @Test
    public void example2() {
        String s = "ccaabbb";
        int expected = 5;
        Assertions.assertEquals(expected, solutionP159.lengthOfLongestSubstringTwoDistinct(s));
    }
}
