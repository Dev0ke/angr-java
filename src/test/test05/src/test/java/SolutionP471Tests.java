import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP471Tests {
    private final SolutionP471 solutionP471 = new SolutionP471();

    @Test
    public void example1() {
        String s = "aaa";
        String expected = "aaa";
        Assertions.assertEquals(expected, solutionP471.encode(s));
    }

    @Test
    public void example2() {
        String s = "aaaaa";
        String expected = "5[a]";
        Assertions.assertEquals(expected, solutionP471.encode(s));
    }

    @Test
    public void example3() {
        String s = "aaaaaaaaaa";
        // "a9[a]" 或 "9[a]a" 都是合法的编码，和 "10[a]" 一样长度都为 5。
        String expected = "10[a]";
        Assertions.assertEquals(expected, solutionP471.encode(s));
    }

    @Test
    public void example4() {
        String s = "aabcaabcd";
        // "aabc" 出现两次，因此一种答案可以是 "2[aabc]d"。
        String expected = "2[aabc]d";
        Assertions.assertEquals(expected, solutionP471.encode(s));
    }

    @Test
    public void example5() {
        String s = "abbbabbbcabbbabbbc";
        // "abbbabbbc" 出现两次，但是 "abbbabbbc" 可以编码为 "2[abbb]c"，因此一种答案可以是 "2[2[abbb]c]"。
        String expected = "2[2[abbb]c]";
        Assertions.assertEquals(expected, solutionP471.encode(s));
    }
}