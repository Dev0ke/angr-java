import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1153Tests {
    private final SolutionP1153 solutionP1153 = new SolutionP1153();

    @Test
    public void example1() {
        String str1 = "aabcc";
        String str2 = "ccdee";
        Assertions.assertTrue(solutionP1153.canConvert(str1, str2));
    }

    @Test
    public void example2() {
        String str1 = "leetcode";
        String str2 = "codeleet";
        Assertions.assertFalse(solutionP1153.canConvert(str1, str2));
    }
}