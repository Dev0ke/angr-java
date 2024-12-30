import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution125Tests {
    private final Solution125 solution125 = new Solution125();

    @Test
    public void example1() {
        String s = "A man, a plan, a canal: Panama";
        Assertions.assertTrue(solution125.isPalindrome(s));
    }

    @Test
    public void example2() {
        String s = "race a car";
        Assertions.assertFalse(solution125.isPalindrome(s));
    }
}
