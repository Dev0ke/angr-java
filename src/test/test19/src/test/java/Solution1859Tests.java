import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1859Tests {
    private final Solution1859 solution1859 = new Solution1859();

    @Test
    public void example1() {
        String s = "is2 sentence4 This1 a3";
        String expected = "This is a sentence";
        Assertions.assertEquals(expected, solution1859.sortSentence(s));
    }

    @Test
    public void example2() {
        String s = "Myself2 Me1 I4 and3";
        String expected = "Me Myself and I";
        Assertions.assertEquals(expected, solution1859.sortSentence(s));
    }
}
