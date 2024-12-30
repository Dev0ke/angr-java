import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution966Tests {
    private final Solution966 solution966 = new Solution966();

    @Test
    public void example1() {
        String[] wordlist = {"KiTe", "kite", "hare", "Hare"};
        String[] queries = {"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};
        String[] expected = {"kite", "KiTe", "KiTe", "Hare", "hare", "", "", "KiTe", "", "KiTe"};
        Assertions.assertArrayEquals(expected, solution966.spellchecker(wordlist, queries));
    }

    @Test
    public void example2() {
        String[] wordlist = {"yellow"};
        String[] queries = {"YellOw"};
        String[] expected = {"yellow"};
        Assertions.assertArrayEquals(expected, solution966.spellchecker(wordlist, queries));
    }
}