import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution824Tests {
    private final Solution824 solution824 = new Solution824();

    @Test
    public void example1() {
        String sentence = "I speak Goat Latin";
        String expected = "Imaa peaksmaaa oatGmaaaa atinLmaaaaa";
        Assertions.assertEquals(expected, solution824.toGoatLatin(sentence));
    }

    @Test
    public void example2() {
        String sentence = "The quick brown fox jumped over the lazy dog";
        String expected = "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa";
        Assertions.assertEquals(expected, solution824.toGoatLatin(sentence));
    }
}