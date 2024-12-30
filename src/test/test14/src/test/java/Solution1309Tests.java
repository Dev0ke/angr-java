import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1309Tests {
    private final Solution1309 solution1309 = new Solution1309();

    @Test
    public void example1() {
        String s = "10#11#12";
        String expected = "jkab";
        Assertions.assertEquals(expected, solution1309.freqAlphabets(s));
    }

    @Test
    public void example2() {
        String s = "1326#";
        String expected = "acz";
        Assertions.assertEquals(expected, solution1309.freqAlphabets(s));
    }

    @Test
    public void example3() {
        String s = "25#";
        String expected = "y";
        Assertions.assertEquals(expected, solution1309.freqAlphabets(s));
    }

    @Test
    public void example4() {
        String s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
        String expected = "abcdefghijklmnopqrstuvwxyz";
        Assertions.assertEquals(expected, solution1309.freqAlphabets(s));
    }
}
