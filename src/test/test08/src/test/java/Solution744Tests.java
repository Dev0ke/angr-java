import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution744Tests {
    private final Solution744 solution744 = new Solution744();

    @Test
    public void example1() {
        char[] letters = {'c', 'f', 'j'};
        char target = 'a';
        char expected = 'c';
        Assertions.assertEquals(expected, solution744.nextGreatestLetter(letters, target));
    }

    @Test
    public void example2() {
        char[] letters = {'c', 'f', 'j'};
        char target = 'c';
        char expected = 'f';
        Assertions.assertEquals(expected, solution744.nextGreatestLetter(letters, target));
    }

    @Test
    public void example3() {
        char[] letters = {'c', 'f', 'j'};
        char target = 'd';
        char expected = 'f';
        Assertions.assertEquals(expected, solution744.nextGreatestLetter(letters, target));
    }
}
