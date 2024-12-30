import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1119Tests {
    private final SolutionP1119 solutionP1119 = new SolutionP1119();

    @Test
    public void example1() {
        String s = "leetcodeisacommunityforcoders";
        String expected = "ltcdscmmntyfrcdrs";
        Assertions.assertEquals(expected, solutionP1119.removeVowels(s));
    }

    @Test
    public void example2() {
        String s = "aeiou";
        String expected = "";
        Assertions.assertEquals(expected, solutionP1119.removeVowels(s));
    }
}
